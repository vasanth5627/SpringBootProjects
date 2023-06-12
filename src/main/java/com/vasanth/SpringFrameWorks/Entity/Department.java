package com.vasanth.SpringFrameWorks.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity //to make it interact with database
@Data //to enable LOMBOK - we get everything
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id //to make it primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Please add Department Name")
    @Length(max = 10, min = 1)
//    @Size(max=10, min=0)
//    @Email
//    @Positive
//    @Negative
//    @PositiveOrZero
//    @NegativeOrZero
//    @Future
//    @FutureOrPresent
//    @Past
//    @PastOrPresent
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

//    public Long getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(Long departmentId) {
//        this.departmentId = departmentId;
//    }
//
//    public String getDepartmentName() {
//        return departmentName;
//    }
//
//    public void setDepartmentName(String departmentName) {
//        this.departmentName = departmentName;
//    }
//
//    public String getDepartmentAddress() {
//        return departmentAddress;
//    }
//
//    public void setDepartmentAddress(String departmentAddress) {
//        this.departmentAddress = departmentAddress;
//    }
//
//    public String getDepartmentCode() {
//        return departmentCode;
//    }
//
//    public void setDepartmentCode(String departmentCode) {
//        this.departmentCode = departmentCode;
//    }
//
//    public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
//        this.departmentId = departmentId;
//        this.departmentName = departmentName;
//        this.departmentAddress = departmentAddress;
//        this.departmentCode = departmentCode;
//    }
//
//    public Department() {
//    }
//
//    @Override
//    public String toString() {
//        return "Department{" +
//                "departmentId=" + departmentId +
//                ", departmentName='" + departmentName + '\'' +
//                ", departmentAddress='" + departmentAddress + '\'' +
//                ", departmentCode='" + departmentCode + '\'' +
//                '}';
//    }
}
