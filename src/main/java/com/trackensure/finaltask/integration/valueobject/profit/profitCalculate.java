package com.trackensure.finaltask.integration.valueobject.profit;

/**
 * ---------------------------------------------------------------------------------------------------------------- <br>
 * Интерфейс расчета прибыли. <br>
 * ---------------------------------------------------------------------------------------------------------------- <br>
 */
public interface profitCalculate {
    static double profitCalc(int preferenceWT, int currentWT) {
        double profit;
        /*--- Нет предпочтений ----------- Желаемое время = стандартное время--------------- Хочет работать из дому но нельзя ------ */
        if ((preferenceWT == 0) || ((preferenceWT == 900) & (currentWT == 900)) || (preferenceWT == 3000 & currentWT != 3000)) {
            profit = 1;
            /*-- Хочет работать и работает из дома --*/
        } else if ((preferenceWT & currentWT) == 3000) {
            profit = 1.1;
            /*-- Хочет работать и работает с 00:00 --*/
        } else if ((preferenceWT & currentWT) == 2400) {
            profit = 2.8;
            /*-------------- Хочет работ с 00:00 но нельзя ------------*/
        } else if ((preferenceWT != currentWT) & (preferenceWT == 2400)) {
            profit = 1 - (currentWT / 100.0 * 0.2);
        } else {
            /* График НЕ соответствует предпочтениям */
            if (preferenceWT > currentWT) {
                profit = 1 - ((preferenceWT - currentWT) / 100.0 * 0.2);
            }
            /* График НЕ соответствует предпочтениям */
            else if (currentWT > preferenceWT) {
                profit = 1 - ((currentWT - preferenceWT) / 100.0 * 0.2);
            }
            /* График СООТВЕТСВУЕТ предпочтениям */
            else if (preferenceWT < 900) {
                profit = 1 + ((900 - preferenceWT) / 100.0 * 0.2);
            }
            /* График СООТВЕТСВУЕТ предпочтениям */
            else profit = 1 + ((preferenceWT - 900) / 100.0 * 0.2);
        }
        return profit;
    }
}
