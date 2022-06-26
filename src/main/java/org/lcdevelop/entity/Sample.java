package org.lcdevelop.entity;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;

@XmlRootElement
public class Sample {

    private Long id;
    private Integer intNum;
    private Long longNum;
    private BigDecimal bigDecimalNum;
    private Date date01;
    private String name;
    private String description;

    public Sample() {
    }

    public Sample(Long id, Integer intNum, Long longNum, BigDecimal bigDecimalNum, Date date01, String name, String description) {
        this.id = id;
        this.name = name;
        this.intNum = intNum;
        this.longNum = longNum;
        this.bigDecimalNum = bigDecimalNum;
        this.date01 = date01;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIntNum() {
        return intNum;
    }

    public void setIntNum(Integer intNum) {
        this.intNum = intNum;
    }

    public Long getLongNum() {
        return longNum;
    }

    public void setLongNum(Long longNum) {
        this.longNum = longNum;
    }

    public BigDecimal getBigDecimalNum() {
        return bigDecimalNum;
    }

    public void setBigDecimalNum(BigDecimal bigDecimalNum) {
        this.bigDecimalNum = bigDecimalNum;
    }

    public Date getDate01() {
        return date01;
    }

    public void setDate01(Date date01) {
        this.date01 = date01;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Sample{" + "id=" + id + ", intNum=" + intNum + ", longNum=" + longNum + ", bigDecimalNum=" + bigDecimalNum + ", date01=" + date01 + ", name=" + name + ", description=" + description + '}';
    }
}
