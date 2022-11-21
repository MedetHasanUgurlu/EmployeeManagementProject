import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { useParams } from "react-router-dom";

import EmployeeService from "../services/EmployeeService";
import {
  Card,
  CardBody,
  CardTitle,
  CardSubtitle,
  CardText,
} from "reactstrap";

function ViewEmployee() {
  
  const [employee, setEmployee] = useState({});
  let { id } = useParams();

  

  useEffect(() => {
    console.log(id)
   EmployeeService.getEmployeeById(id).then((data)=>setEmployee(data.data));
   console.log(employee);
  }, []);

  return (
    <>
      <div className="card text-center mt-5">
        <div className="card-header">Müşteri Detay sayfası</div>
        <div className="card-body">
          <Card
            color="light"
            style={{
              width: "18rem",
              marginLeft:"auto",
              marginRight:"auto"
            }}
          >
            <img alt="Sample" src="https://picsum.photos/300/200" />
            <CardBody>
              <CardTitle tag="h5">{employee.name} {employee.surname}</CardTitle>
              <CardSubtitle className="mb-2 text-muted" tag="h6">
                
              </CardSubtitle>
              <CardText>
                Email: {employee.email}    /
                Password: {employee.password}
              
              
              
              </CardText>
            </CardBody>
          </Card>
        </div>
      </div>
      {/* <div className="card-footer text-muted">{this.state.employee.systemCreatedDate}</div> */}
    </>
  );
}

export default ViewEmployee;
