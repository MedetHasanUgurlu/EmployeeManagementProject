import { Component } from "react";
import { Table } from "reactstrap";
import EmployeeService from "../services/EmployeeService";
import { Link, useNavigate } from "react-router-dom";

class EmployeeList extends Component {
  //Constructor
  constructor(props) {
    super(props);
    //State
    this.state = { employees: [] };
    //Bind
    this.deleteEmployee = this.deleteEmployee.bind(this);
  }

  
  componentDidMount() {
    EmployeeService.getEmployees().then((response) => {
      this.setState({
        employees: response.data,
      });
    });
  }

  //DELETE
  deleteEmployee(id) {
    EmployeeService.deleteEmployeeById(id).then(
      (response) => {
        this.setState({
          employees: this.state.employees.filter(
            (employee) => employee.id != id
          ), //end filter
        }); //end setState
      } //end response
    ); //end then
  } //end deleteEmployee

  render() {
    return (
      <div className="container">
        <h1 className="text-center ">Müşteri Listesi</h1>
        <div className="mx-auto">
          <Link to="/employee-add/_add" className="btn btn-secondary">
            ADD
          </Link>

        </div>
        <Table hover>
          <thead>
            <tr>
              <th>#</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Password</th>
              <th>Email</th>
              <th>View</th>
              <th>Update</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>
            {this.state.employees.map((x) => (
              <tr key={x.id}>
                <td>{x.id}</td>
                <td>{x.name}</td>
                <td>{x.surname}</td>
                <td>{x.password}</td>
                <td>{x.email}</td>
                <td>
                  <Link to={`employee-view/${x.id}`} className="btn btn-success">
                    View
                  </Link>
                </td>
                <td>
                  <Link
                    to={`/employee-add/${x.id}`}
                    className="btn btn-primary"
                  >
                    Update
                  </Link>
                </td>
                <td>
                  <button
                    className="btn btn-danger"
                    onClick={() => {
                      if (window.confirm("silmek istiyor musunuz ?"))
                        this.deleteEmployee(x.id);
                    }}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}

          </tbody>
        </Table>
      </div>
    );
  }
}
export default EmployeeList;



// import { Suspense, useState } from "react";
// import i18n from "i18next";
// import { useTranslation, initReactI18next, Trans } from "react-i18next";


// const translationsEn = {
//   firstname: "First Name!"
// };

// const translationsTr = {
//   firstname: "İsim!",
// };

// i18n
//   .use(initReactI18next) // passes i18n down to react-i18next
//   .init({
//     resources: {
//       en: { translation: translationsEn },
//       fr: { translation: translationsTr },
//     },
//     lng: "en",
//     fallbackLng: "en",
//     interpolation: { escapeValue: false },
//   });

// const App = () => {
//   const { t } = useTranslation();

//   const onChange = (event) => {
//     i18n.changeLanguage(event.target.value);
//     setCount((previousCount) => previousCount + 1);
//   };

