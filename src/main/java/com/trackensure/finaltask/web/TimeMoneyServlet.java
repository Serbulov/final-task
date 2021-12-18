package com.trackensure.finaltask.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trackensure.finaltask.integration.dao.*;
import com.trackensure.finaltask.integration.valueobject.*;
import com.trackensure.finaltask.integration.valueobject.profit.CompanyProfit;
import com.trackensure.finaltask.integration.valueobject.profit.DepartmentProfit;
import com.trackensure.finaltask.integration.valueobject.profit.EmployeeProfit;
import com.trackensure.finaltask.web.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name = "helloServlet", value = {
        /* ---------------------------- Отображение форм ввода данных ---------------------------- */
        "/new-employee", "/new-department", "/new-role", "/new-salary-type",
        /* ------------------ Вывод на экран содержимого таблиц из БД через JSON ----------------- */
        "/show-all-employee", "/show-all-department", "/show-all-role", "/show-all-salary-type",
        "/show-all-working-hours",
        /* --------------------- Отображение форм изменения рабочих графиков --------------------- */
        "/indicate-preferred-working-hours-for-emp", "/indicate-preferred-working-hours-for-dep",
        "/update-working-hours-for-emp", "/update-working-hours-for-dep",
        /* ------------------- Отображение результатов изменения рабочих часов ------------------- */
        "/show-general-report", "/show-emp-report", "/show-dep-report",
        /* ----------------------------------- Добавление в БД ----------------------------------- */
        "/add-new-emp", "/add-new-dep", "/add-new-role", "/add-new-salary-type"})

public class TimeMoneyServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    private DepartmentDAO departmentDAO;
    private RoleDAO roleDAO;
    private SalaryTypeDAO salaryTypeDAO;
    private WorkingHoursDAO workingHoursDAO;
    private ProfitDAO profitDAO;

    public void init() {
        this.employeeDAO = new EmployeeDAO();
        this.departmentDAO = new DepartmentDAO();
        this.roleDAO = new RoleDAO();
        this.salaryTypeDAO = new SalaryTypeDAO();
        this.workingHoursDAO = new WorkingHoursDAO();
        this.profitDAO = new ProfitDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * ------------------------------------------------------------------------------------------------------------ <br>
     * Главный метод, выполняющийся как через doGet, так и через doPost. <br>
     * ------------------------------------------------------------------------------------------------------------ <br>
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ServletUtil servletUtil = new ServletUtil(request, response);
        if (servletUtil.getActionName() == null) {
            defaultOutput(response, "<h1>Null</h1>");
            return;
        }
        switch (servletUtil.getActionName()) {
            /* <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Главное меню >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> */

            /*------------------------------------------ Кнопки ввода данных -----------------------------------------*/
            case "new-emp": {
                request.getRequestDispatcher("/addObjects/new_emp.jsp").forward(request, response);
                break;
            }

            case "new-dep": {
                request.getRequestDispatcher("/addObjects/new_dep.jsp").forward(request, response);
                break;
            }

            case "new-role": {
                request.getRequestDispatcher("/addObjects/new_role.jsp").forward(request, response);
                break;
            }

            case "new-salary-type": {
                request.getRequestDispatcher("/addObjects/new_salary_type.jsp").forward(request, response);
                break;
            }

            /*-------------------------------------- Кнопки отображения данных ---------------------------------------*/
            case "show-all-emp": {
                List<Employee> employeeList = employeeDAO.findAllEmp();
                showAllEmp(employeeList, response);
            }
            case "show-all-dep": {
                List<Department> departmentList = departmentDAO.findAllDep();
                showAllDep(departmentList, response);
            }

            case "show-all-role": {
                List<Role> roleList = roleDAO.findAllRole();
                showAllRole(roleList, response);
            }

            case "show-all-salary-type": {
                List<SalaryType> salaryTypeList = salaryTypeDAO.findAllSalaryType();
                showAllSalaryType(salaryTypeList, response);
            }
            case "show-all-working-hours": {
                List<WorkingHours> workingHoursList = workingHoursDAO.findAllWorkingHours();
                showAllWorkingHours(workingHoursList, response);
            }

            /*----------------------------------- Кнопки изменения методов работы ------------------------------------*/
            case "indicate-preferred-working-hours-for-emp": {
                request.getRequestDispatcher(
                        "/changeWorkingHours/indicate_preferred_working_hours_for_emp.jsp").forward(request, response);
                break;
            }
            case "indicate-preferred-working-hours-for-dep": {
                request.getRequestDispatcher(
                        "/changeWorkingHours/indicate_preferred_working_hours_for_dep.jsp").forward(request, response);
                break;
            }

            case "update-working-hours-for-emp": {
                request.getRequestDispatcher(
                        "/changeWorkingHours/change_employee_working_hours.jsp").forward(request, response);
                break;
            }

            case "update-working-hours-for-dep": {
                request.getRequestDispatcher(
                        "/changeWorkingHours/change_working_hours_department.jsp").forward(request, response);
                break;
            }

            /*------------------------------- Кнопки предоставления прибыли | убытков --------------------------------*/
            case "show-general-report": {
                List<EmployeeProfit> profitList = profitDAO.profitForAllEmp();
                showProfitForCompany(profitList, response);
            }

            case "show-emp-report": {
                List<EmployeeProfit> profitList = profitDAO.profitForAllEmp();
                showAllProfitForEmp(profitList, response);
            }

            case "show-dep-report": {
                List<EmployeeProfit> profitList = profitDAO.profitForAllEmp();
                showAllProfitForDep(profitList, response);
            }
            /* <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Второстепенные страницы >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> */

            /*------------------------------------- Кнопки добавления данных в БД ------------------------------------*/
            case "add-new-emp": {
                addNewEmp(request);
                workingHoursDAO.addNewWorkingHours();
                request.getRequestDispatcher("/successful_addition.jsp").forward(request, response);
                break;
            }

            case "add-new-dep": {
                addNewDep(request);
                request.getRequestDispatcher("/successful_addition.jsp").forward(request, response);
                break;
            }

            case "add-new-role": {
                addNewRole(request);
                request.getRequestDispatcher("/successful_addition.jsp").forward(request, response);
                break;
            }
            case "add-new-salary-type": {
                addNewSalaryType(request);
                request.getRequestDispatcher("/successful_addition.jsp").forward(request, response);
                break;
            }
            /*---------- Кнопки изменения желаемого / действующего рабочего времени в таблице working_hours ----------*/
            case "change-preferred-working-hours-for-emp": {
                changePreferredWorkingHoursForEmp(request);
                request.getRequestDispatcher("/successful_addition.jsp").forward(request, response);
                break;
            }
            case "change-preferred-working-hours-for-dep": {
                changePreferredWorkingHoursForDep(request);
                request.getRequestDispatcher("/successful_addition.jsp").forward(request, response);
                break;
            }

            case "change-current-working-hours-for-emp": {
                changeCurrentWorkingHoursForEmp(request);
                request.getRequestDispatcher("/successful_addition.jsp").forward(request, response);
                break;
            }

            case "change-current-working-hours-for-dep": {
                changeCurrentWorkingHoursForDep(request);
                request.getRequestDispatcher("/successful_addition.jsp").forward(request, response);
                break;
            }

            /* ----------------------------------------- Дефолтное значение ----------------------------------------- */
            default: {
                defaultOutput(response, "<h1>None</h1>");
                break;
            }
        }
    }

    /* ============================================================================================================== */
    /* ------------------------------------- Методы добавления информации в БД -------------------------------------- */

    private void addNewEmp(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String[] depValues = request.getParameterValues("department-name");
        int departmentId = Integer.parseInt(depValues[0]);
        String[] roleValues = request.getParameterValues("role-name");
        int roleId = Integer.parseInt(roleValues[0]);
        int salary = Integer.parseInt(request.getParameter("salary"));
        String[] salaryTypeValues = request.getParameterValues("salary-type");
        int salaryTypeId = Integer.parseInt(salaryTypeValues[0]);
        Employee employee = new Employee(firstName, lastName, departmentId, roleId, salary, salaryTypeId);
        employeeDAO.addNewEmployee(employee);
    }

    private void addNewDep(HttpServletRequest request) {
        String departmentName = request.getParameter("department-name");
        Department department = new Department(departmentName);
        departmentDAO.addNewDepartment(department);
    }

    private void addNewRole(HttpServletRequest request) {
        String roleName = request.getParameter("role-name");
        String roleFunctionArea = request.getParameter("role-function-area");
        Role role = new Role(roleName, roleFunctionArea);
        roleDAO.addNewRole(role);
    }

    private void addNewSalaryType(HttpServletRequest request) {
        String salaryTypeName = request.getParameter("salary-type-name");
        SalaryType salaryType = new SalaryType(salaryTypeName);
        salaryTypeDAO.addNewSalaryType(salaryType);
    }

    /* ------------------------------------------ Методы отображение данных ----------------------------------------- */

    private void showAllWorkingHours(List<WorkingHours> workingHoursList, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, workingHoursList);
    }

    private void showAllSalaryType(List<SalaryType> salaryTypeList, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, salaryTypeList);
    }

    private void showAllRole(List<Role> roleList, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, roleList);
    }

    private void showAllDep(List<Department> departmentList, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, departmentList);
    }

    private void showAllEmp(List<Employee> employeeList, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, employeeList);
    }

    /* ------------- Методы изменения желаемого / действующего рабочего времени в таблице working_hours ------------- */

    private void changePreferredWorkingHoursForEmp(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("employeeID"));
        String[] workingHoursValues = request.getParameterValues("working-hours");
        int workingHoursCode = Integer.parseInt(workingHoursValues[0]);
        workingHoursDAO.updatePreferenceWTForEmp(employeeId, workingHoursCode);
    }

    private void changePreferredWorkingHoursForDep(HttpServletRequest request) {
        String[] departmentIDValue = request.getParameterValues("departmentID");
        int departmentID = Integer.parseInt(departmentIDValue[0]);
        String[] workingHoursValues = request.getParameterValues("working-hours");
        int workingHoursCode = Integer.parseInt(workingHoursValues[0]);
        workingHoursDAO.updatePreferenceWTForDep(departmentID, workingHoursCode);
    }

    private void changeCurrentWorkingHoursForEmp(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("employeeID"));
        String[] workingHoursValues = request.getParameterValues("working-hours");
        int workingHoursCode = Integer.parseInt(workingHoursValues[0]);
        workingHoursDAO.updateCurrentWTForEmp(employeeId, workingHoursCode);
    }

    private void changeCurrentWorkingHoursForDep(HttpServletRequest request) {
        String[] departmentIDValue = request.getParameterValues("departmentID");
        int departmentID = Integer.parseInt(departmentIDValue[0]);
        String[] workingHoursValues = request.getParameterValues("working-hours");
        int workingHoursCode = Integer.parseInt(workingHoursValues[0]);
        workingHoursDAO.updateCurrentWTForDep(departmentID, workingHoursCode);
    }

    /* ----------------------------------------- Методы отображение прибыли ----------------------------------------- */

    private void showProfitForCompany(List<EmployeeProfit> profitList, HttpServletResponse response) throws IOException {
        double summaryProfit = summaryProfitCalc(profitList);
        CompanyProfit companyProfit = new CompanyProfit("Company Name", summaryProfit);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, companyProfit);
    }
    private double summaryProfitCalc(List<EmployeeProfit> profitList) {
        double a = profitList.stream().map(x -> (x.getProfit() - 1.0)).mapToDouble(Double::doubleValue).sum();
        double b = profitList.size();
        return (a / b) + 1;
    }

    private void showAllProfitForEmp(List<EmployeeProfit> profitList, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, profitList);
    }

    /* Класс показывающий прибыль по каждому департаменту (работает - не трогай) */
    private void showAllProfitForDep(List<EmployeeProfit> profitList, HttpServletResponse response) throws IOException {
        List<DepartmentProfit> ListDepFromEmp = profitList.stream()
                .map(x -> new DepartmentProfit(x.getDepartmentID(), x.getDepartmentName(), x.getProfit())).collect(Collectors.toList());

        List<DepartmentProfit> departmentProfitList = ListDepFromEmp.stream()
                .collect(Collectors.groupingBy(DepartmentProfit::getDepartmentID))
                .values().stream()
                .map(departmentProfits -> departmentProfits.stream()
                        .reduce((a, b) -> new DepartmentProfit(a.getDepartmentID(), a.getDepartmentName(), a.getDepartmentProfit() + b.getDepartmentProfit()-1 )))
                .map(Optional::get).collect(Collectors.toList());
        for (DepartmentProfit departmentProfit : departmentProfitList) {
            double depProfit = ((departmentProfit.getDepartmentProfit() - 1) / profitList.size()) + 1;
            departmentProfit.setDepartmentProfit(depProfit);
        }

        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, departmentProfitList);
    }

    /* ---------------------------------------------- Дефолтный метод ----------------------------------------------- */
    private void defaultOutput(HttpServletResponse response, String x) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println(x);
        out.println("</body></html>");
    }

    public void destroy() {
    }
}