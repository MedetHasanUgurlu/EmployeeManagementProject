
import axios from "axios";

class EmployeeService {
     

    // SAVE
    createEmployee(employeeDto){
        return axios.post("http://localhost:8080/employee/api/v1/employee",employeeDto)
    }

    // LIST
    getEmployees(){
        return axios.get("http://localhost:8080/employee/api/v1/employees")
    }

    // FIND
    getEmployeeById(id){
        return axios.get("http://localhost:8080/employee/api/v1/employee/"+id);
    }

    // DELETE
    deleteEmployeeById(id){
        return axios.delete("http://localhost:8080/employee/api/v1/employee/"+id);
    }

    // UPDATE
    updateEmployeeById(id,employeeDto){
        return axios.put("http://localhost:8080/employee/api/v1/employee/"+id,employeeDto);
    }

}

export default new EmployeeService();