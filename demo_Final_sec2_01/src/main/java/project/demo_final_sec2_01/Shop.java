package project.demo_final_sec2_01;

import java.io.Serializable;

public class Shop implements Serializable {
    private String name;
    private String zipCode;
    private int areaInSqFt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getAreaInSqFt() {
        return areaInSqFt;
    }

    public void setAreaInSqFt(int areaInSqFt) {
        this.areaInSqFt = areaInSqFt;
    }

    public Shop(String name, String zipCode, int areaInSqFt) {
        this.name = name;
        this.zipCode = zipCode;
        this.areaInSqFt = areaInSqFt;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", areaInSqFt=" + areaInSqFt +
                '}';
    }
}
