import React from "react";
import { useFormik } from "formik";
import { useState } from "react";
import EmployeeService from "../services/EmployeeService";
import { useParams } from "react-router-dom";
import { Link, useNavigate } from "react-router-dom";

 import i18n from "i18next";
 import { useTranslation, initReactI18next, Trans } from "react-i18next";


function CreateEmployee() {
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  let employee = {
    name: name,
    surname: surname,
    email: email,
    password: password,
  };

  let { id } = useParams();

  const formik = useFormik({
    initialValues: {
      name: "",
      surname: "",
      email: "",
      password: "",
    },
    onSubmit: (values) => {
      EmployeeService.createEmployee(employee);
      console.log(values);
    },
  });

  return (
    <div
      className="container"
      style={{
        justifyContent: "center",
        display: "flex",
        marginBottom: "3rem",
      }}
    >
      <form onSubmit={formik.handleSubmit} style={{ margin: "6px" }}>
        <div>
          <label htmlFor="firstName">Name</label>
        </div>
        <div>
          <div>
            <input
              id="name"
              name="name"
              type="text"
              placeholder="name"
              onChange={(e) => setName(e.target.value)}
            />
          </div>
        </div>

        <div>
          <label htmlFor="surname">Surname</label>
        </div>
        <div>
          <input
            id="surname"
            name="surname"
            type="text"
            onChange={(e) => setSurname(e.target.value)}
            placeholder="surname"
          />
        </div>

        <div>
          <label htmlFor="email">Email</label>
        </div>

        <div>
          <input
            id="email"
            name="email"
            type="email"
            placeholder="email"
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>

        <div>
          <label htmlFor="password">Password</label>
        </div>

        <div>
          <input
            id="password"
            name="password"
            type="password"
            placeholder="password"
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>

        <div
          style={{
            marginTop: "1rem",
            alignContent: "center",
            textAlign: "center",
          }}
        >
          <button type="submit" className="text-center btn btn-secondary">
            Submit
          </button>

          <div style={{marginTop:"1rem"}}>
          <Link to={`/`} className="btn btn-primary">
            Main
          </Link>
          </div>

        </div>
      </form>
    </div>
  );
}

export default CreateEmployee;

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
