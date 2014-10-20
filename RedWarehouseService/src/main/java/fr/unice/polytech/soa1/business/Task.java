package fr.unice.polytech.soa1.business;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 06/10/14.
 */
@XmlType
@XmlRootElement(name = "task")
public class Task {
    private String taskId;
    private List<String> employeesAssignedId;
    private String dayLogEvent;

    public Task(){}

    public Task(String taskId, String dayLogEvent) {
        this.taskId = taskId;
        this.employeesAssignedId = new ArrayList<>();
        this.dayLogEvent = dayLogEvent;
    }

    @XmlElement(name="day_log_event")
    public String getDayLogEvent() {
        return dayLogEvent;
    }
    public void setDayLogEvent(String dayLogEvent) {
        this.dayLogEvent = dayLogEvent;
    }

    @XmlElement(name="employees_assigned")
    public List<String> getEmployeesAssignedId() {
        return employeesAssignedId;
    }
    public void setEmployeesAssignedId(List<String> employeesAssignedId) {
        this.employeesAssignedId = employeesAssignedId;
    }

    @XmlElement(name="task_id")
    @XmlID
    public String getTaskId() {
        return taskId;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void addEmployee(String employeeId){
        this.employeesAssignedId.add(employeeId);
    }
}
