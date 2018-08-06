import java.util.*;
public class CalcRunner {
    private double K_aValue;
    private double acidVolume;
    private double acidConcentration;
    private double K_bValue;
    private double baseVolume;
    private double baseConcentration;
    private int calcCase;
    private double desiredPH;
    private boolean equivalencePoint = false;
    private boolean midPoint = false;
    private double outputPH;
    private String message;


    public CalcRunner(double kaVal, double acidVol, double acidConc, double kbVal, double baseVol, double baseConc, double dPH, boolean eP, boolean mP, int CC) {
        K_aValue = kaVal;
        acidVolume = acidVol * 0.001;
        acidConcentration = acidConc;
        K_bValue = kbVal;
        baseVolume = baseVol * 0.001;
        baseConcentration = baseConc;
        desiredPH = dPH;
        equivalencePoint = eP;
        midPoint = mP;
        calcCase = CC;
    }

    public String getMessage() {
        return message;
    }

    public void Calculate() {
        switch (calcCase) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
        }
    }

    public void Case5Operation() {
        if (K_aValue >= 1000 && K_bValue >= 1000) { //Strong Acid Strong Base
            message = "pH = " + outputPH;
        } else if (K_aValue >= 1000) { //Strong Acid Weak Base

        } else if (K_bValue >= 1000) { // Weak Acid Strong Base

        }
    }

    public void Case5StrongAcidStrongBase() {
        double molesAcid = acidVolume * acidConcentration;
        double molesBase = baseVolume * baseConcentration;
        if (molesAcid == molesBase) {
            outputPH = 7;
        } else if (molesAcid > molesBase) {
            outputPH = -1 * Math.log10((molesAcid - molesBase) / (acidVolume + baseVolume));
        } else if (molesBase > molesAcid) {
            outputPH = -1 * Math.log10((molesBase - molesAcid) / (acidVolume + baseVolume));
        }
    }

    public void Case5WeakAcidStrongBase() {
        double molesAcid = acidVolume * acidConcentration;
        double molesBase = baseVolume * baseConcentration;
        if (molesBase == 0) {
            outputPH = -1 * Math.log10(QuadraticFormula(1, K_aValue, -1 * K_aValue * acidConcentration));
        } else if (molesBase < molesAcid) {
            molesAcid = molesAcid - molesBase;
            double molesConjugateBase = molesBase;
            outputPH = -1 * Math.log10(K_aValue) + Math.log10(molesConjugateBase / molesAcid);
        } else if (molesBase == molesAcid) {
            double concentrationConjugateBase = molesBase / (acidVolume + baseVolume);
            double tempKb = 1.0 * Math.pow(10.0, -14.0) / (K_aValue);
            outputPH = 14 - Math.log10(QuadraticFormula(1, tempKb, -1 * tempKb * concentrationConjugateBase));
        } else if (molesBase > molesAcid) {
            double molesExcessBase = molesBase - molesAcid;
            outputPH = 14 - Math.log10(molesExcessBase / (acidVolume + baseVolume));
        }
    }

    public double QuadraticFormula(double a, double b, double c) {
        return (-1 * b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    }
}
//https://chem.libretexts.org/Demos%2C_Techniques%2C_and_Experiments/General_Lab_Techniques/Titration