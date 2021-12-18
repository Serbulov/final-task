--
-- PostgreSQL database dump
--

-- Dumped from database version 12.9
-- Dumped by pg_dump version 12.9


SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 206 (class 1259 OID 16918)
-- Name: department; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.department (
    department_id integer NOT NULL,
    department_name character varying NOT NULL
);


ALTER TABLE public.department OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16948)
-- Name: department_department_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.department_department_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.department_department_id_seq OWNER TO postgres;

--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 209
-- Name: department_department_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.department_department_id_seq OWNED BY public.department.department_id;


--
-- TOC entry 205 (class 1259 OID 16905)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    employee_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    department_id integer,
    role_id integer,
    salary double precision,
    salary_type_id integer
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16903)
-- Name: employees_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employees_employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employees_employee_id_seq OWNER TO postgres;

--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 204
-- Name: employees_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employees_employee_id_seq OWNED BY public.employees.employee_id;


--
-- TOC entry 208 (class 1259 OID 16929)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    role_id integer NOT NULL,
    role_name character varying NOT NULL,
    functional_area character varying
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16927)
-- Name: role_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_role_id_seq OWNER TO postgres;

--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 207
-- Name: role_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_role_id_seq OWNED BY public.role.role_id;


--
-- TOC entry 203 (class 1259 OID 16872)
-- Name: salaries; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.salaries (
    salary_type_id integer NOT NULL,
    salary_type_name character varying
);


ALTER TABLE public.salaries OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16870)
-- Name: salaries_salary_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.salaries_salary_type_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.salaries_salary_type_id_seq OWNER TO postgres;

--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 202
-- Name: salaries_salary_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.salaries_salary_type_id_seq OWNED BY public.salaries.salary_type_id;


--
-- TOC entry 210 (class 1259 OID 16964)
-- Name: working_hours; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.working_hours (
    employee_id integer,
    role_id integer,
    department_id integer,
    preferance_wt integer DEFAULT 0,
    current_wt integer DEFAULT 900
);


ALTER TABLE public.working_hours OWNER TO postgres;

--
-- TOC entry 2714 (class 2604 OID 16950)
-- Name: department department_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department ALTER COLUMN department_id SET DEFAULT nextval('public.department_department_id_seq'::regclass);


--
-- TOC entry 2713 (class 2604 OID 16908)
-- Name: employees employee_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees ALTER COLUMN employee_id SET DEFAULT nextval('public.employees_employee_id_seq'::regclass);


--
-- TOC entry 2715 (class 2604 OID 16932)
-- Name: role role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN role_id SET DEFAULT nextval('public.role_role_id_seq'::regclass);


--
-- TOC entry 2712 (class 2604 OID 16875)
-- Name: salaries salary_type_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.salaries ALTER COLUMN salary_type_id SET DEFAULT nextval('public.salaries_salary_type_id_seq'::regclass);


--
-- TOC entry 2862 (class 0 OID 16918)
-- Dependencies: 206
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.department (department_id, department_name) VALUES (1, 'Офис CIO');
INSERT INTO public.department (department_id, department_name) VALUES (2, 'Отдел управления');
INSERT INTO public.department (department_id, department_name) VALUES (3, 'Бизнес отдел');
INSERT INTO public.department (department_id, department_name) VALUES (4, 'Группа по управлению ИТ');
INSERT INTO public.department (department_id, department_name) VALUES (5, 'Комитет по работе с клиентами');


--
-- TOC entry 2861 (class 0 OID 16905)
-- Dependencies: 205
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (2, 'Сергей', 'Орлов', 1, 2, 50000, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (1, 'Иван', 'Иванов', 1, 1, 100000, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (3, 'Марта', 'Артемьева', 1, 3, 20000, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (4, 'Артем', 'Кузнецов', 1, 4, 20000, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (5, 'Сергей', 'Зайцев', 1, 5, 20000, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (6, 'Григорий', 'Иванов', 1, 6, 15000, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (7, 'Тимофей', 'Игнатьев', 1, 6, 15000, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (8, 'Виталий', 'Токарев', 1, 7, 12000, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (9, 'Кирилл', 'Крюков', 1, 8, 12000, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (10, 'Юрий', 'Богданов', 1, 9, 10000, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (11, 'Максим', 'Измайлов', 2, 10, 17000, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (12, 'Павел', 'Безруков', 2, 11, 14000, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (13, 'Иван', 'Воронков', 2, 11, 13000, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (14, 'Афанасий', 'Быков', 2, 11, 13000, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (15, 'Александра', 'Воронова', 2, 12, 16000, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (16, 'Виктор', 'Дегтярев', 2, 12, 15000, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (17, 'Валентина', 'Александрова', 2, 12, 14500, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (18, 'Иннокентий', 'Попов', 2, 13, 12300, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (19, 'Анна', 'Ермолаева', 2, 13, 12500, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (20, 'Илья', 'Глазков', 3, 17, 9700, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (21, 'Алексей', 'Виноградов', 3, 17, 9700, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (22, 'Никита', 'Жданов', 3, 17, 9700, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (23, 'Елизавета', 'Полякова', 3, 17, 9700, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (24, 'Родион', 'Ковалев', 3, 18, 18350, 1);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (25, 'София', 'Селезнева', 3, 19, 12760, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (26, 'Виктор', 'Игнатьев', 3, 19, 14600, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (27, 'Семен', 'Маслов', 3, 19, 12760, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (28, 'Василий', 'Бутусов', 5, 14, 10100, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (29, 'Николай', 'Белых', 5, 15, 10100, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (30, 'Юрий', 'Левков', 5, 16, 10100, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (31, 'Павел', 'Безногов', 5, 14, 10100, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (32, 'Александра', 'Рулёва', 5, 15, 10100, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (33, 'Виктор', 'Порхоменко', 5, 16, 10100, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (34, 'Валентина', 'Дегтярева', 5, 14, 10100, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (35, 'Максим', 'Александров', 5, 15, 10100, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (36, 'Иннокентий', 'Бест', 5, 16, 10100, 3);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (37, 'Тимофей', 'Крюков', 4, 3, 17350, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (38, 'Кирилл', 'Игнатьев', 4, 4, 15540, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (39, 'Марта', 'Попова', 4, 10, 10200, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (40, 'Анна', 'Артемьева', 4, 11, 11960, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (41, 'Илья', 'Измайлов', 4, 12, 13490, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (42, 'Григорий', 'Быков', 4, 12, 13490, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (43, 'Афанасий', 'Иванов', 4, 13, 12480, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (44, 'Виталий', 'Глазков', 4, 13, 12480, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (45, 'Сергей', 'Токарев', 4, 14, 15600, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (46, 'Иван', 'Зайцев', 4, 14, 17500, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (47, 'Артем', 'Воронков', 4, 14, 15600, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (48, 'Алексей', 'Кузнецов', 4, 14, 15600, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (49, 'Никита', 'Ермолаев', 4, 15, 15230, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (50, 'Максим', 'Братко', 4, 15, 15150, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (51, 'Илья', 'Левченко', 4, 15, 15050, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (52, 'Артур', 'Ерошенко', 4, 18, 12480, 2);
INSERT INTO public.employees (employee_id, first_name, last_name, department_id, role_id, salary, salary_type_id) VALUES (102, 'Сергей', 'Сергеев', 3, 4, 4440, 2);


--
-- TOC entry 2864 (class 0 OID 16929)
-- Dependencies: 208
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role (role_id, role_name, functional_area) VALUES (1, 'CIO (ИТ-директор)', 'Управление');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (2, 'Менеджер по развитию бизнеса', 'Управление');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (3, 'Менеджер по Информационной Безопасности', 'Управление');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (4, 'Менеджер по Качеству', 'Управление');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (5, 'Архитектор решений для корпораций', 'Управление');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (6, 'Финансовый аналитик', 'Управление');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (7, 'Менеджер по работе с поставщиками', 'Управление');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (8, 'Юрисконсульт', 'Управление');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (9, 'Менеджер по снабжению', 'Управление');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (10, 'Владелец Проекта', 'Развитие');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (11, 'Специалист по целевому маркетингу', 'Развитие');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (12, 'Руководитель Проекта', 'Развитие');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (13, 'Бизнес-лид', 'Развитие');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (14, 'Руководитель Услуг', 'Услуги');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (15, 'Сервис-менеджер', 'Услуги');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (16, 'Менеджер по коммуникациям через соц. сети', 'Услуги');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (17, 'Менеджер по взаимоотношениям с бизнесом (BRM)', 'Спрос');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (18, 'Ответственный за бизнес-процесс', 'Спрос');
INSERT INTO public.role (role_id, role_name, functional_area) VALUES (19, 'Бизнес-аналитик', 'Спрос');


--
-- TOC entry 2859 (class 0 OID 16872)
-- Dependencies: 203
-- Data for Name: salaries; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.salaries (salary_type_id, salary_type_name) VALUES (2, 'Почасовая оплата.');
INSERT INTO public.salaries (salary_type_id, salary_type_name) VALUES (3, 'Базовый оклад + процент от ежемесячных продаж.');
INSERT INTO public.salaries (salary_type_id, salary_type_name) VALUES (1, 'Базовый оклад (160 рабочих часов).');


--
-- TOC entry 2866 (class 0 OID 16964)
-- Dependencies: 210
-- Data for Name: working_hours; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (2, 2, 1, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (1, 1, 1, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (3, 3, 1, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (4, 4, 1, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (6, 6, 1, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (7, 6, 1, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (9, 8, 1, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (10, 9, 1, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (28, 14, 5, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (29, 15, 5, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (30, 16, 5, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (31, 14, 5, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (32, 15, 5, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (33, 16, 5, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (34, 14, 5, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (35, 15, 5, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (36, 16, 5, NULL, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (5, 5, 1, 700, 900);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (102, 4, 3, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (37, 3, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (38, 4, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (39, 10, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (40, 11, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (41, 12, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (42, 12, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (43, 13, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (8, 7, 1, 300, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (11, 10, 2, 700, 700);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (12, 11, 2, 700, 700);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (13, 11, 2, 700, 700);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (14, 11, 2, 700, 700);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (15, 12, 2, 700, 700);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (16, 12, 2, 700, 700);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (17, 12, 2, 700, 700);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (18, 13, 2, 700, 700);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (19, 13, 2, 700, 700);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (44, 13, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (45, 14, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (46, 14, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (47, 14, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (48, 14, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (49, 15, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (50, 15, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (51, 15, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (52, 18, 4, 600, 600);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (20, 17, 3, 1000, 1000);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (21, 17, 3, 1000, 1000);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (22, 17, 3, 1000, 1000);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (23, 17, 3, 1000, 1000);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (24, 18, 3, 1000, 1000);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (25, 19, 3, 1000, 1000);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (26, 19, 3, 1000, 1000);
INSERT INTO public.working_hours (employee_id, role_id, department_id, preferance_wt, current_wt) VALUES (27, 19, 3, 1000, 1000);


--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 209
-- Name: department_department_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.department_department_id_seq', 7, true);


--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 204
-- Name: employees_employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employees_employee_id_seq', 102, true);


--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 207
-- Name: role_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_role_id_seq', 21, true);


--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 202
-- Name: salaries_salary_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.salaries_salary_type_id_seq', 5, true);


--
-- TOC entry 2723 (class 2606 OID 16958)
-- Name: department department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (department_id);


--
-- TOC entry 2721 (class 2606 OID 16910)
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 2725 (class 2606 OID 16937)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (role_id);


--
-- TOC entry 2719 (class 2606 OID 16880)
-- Name: salaries salaries_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.salaries
    ADD CONSTRAINT salaries_pkey PRIMARY KEY (salary_type_id);


--
-- TOC entry 2728 (class 2606 OID 16959)
-- Name: employees department_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT department_id FOREIGN KEY (department_id) REFERENCES public.department(department_id);


--
-- TOC entry 2731 (class 2606 OID 16977)
-- Name: working_hours department_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.working_hours
    ADD CONSTRAINT department_id FOREIGN KEY (department_id) REFERENCES public.department(department_id);


--
-- TOC entry 2729 (class 2606 OID 16967)
-- Name: working_hours employee_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.working_hours
    ADD CONSTRAINT employee_id FOREIGN KEY (employee_id) REFERENCES public.employees(employee_id);


--
-- TOC entry 2726 (class 2606 OID 16938)
-- Name: employees role_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT role_id FOREIGN KEY (role_id) REFERENCES public.role(role_id);


--
-- TOC entry 2730 (class 2606 OID 16972)
-- Name: working_hours role_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.working_hours
    ADD CONSTRAINT role_id FOREIGN KEY (role_id) REFERENCES public.role(role_id);


--
-- TOC entry 2727 (class 2606 OID 16943)
-- Name: employees salary_type_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT salary_type_id FOREIGN KEY (salary_type_id) REFERENCES public.salaries(salary_type_id);


-- Completed on 2021-12-18 19:14:17

--
-- PostgreSQL database dump complete
--

