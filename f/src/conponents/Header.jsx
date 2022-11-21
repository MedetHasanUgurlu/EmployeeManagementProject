import React, { useState } from "react";

// import i18n from "i18next";
// import { useTranslation, initReactI18next, Trans } from "react-i18next";

import "bootstrap/dist/css/bootstrap.min.css";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,

} from "reactstrap";

function Header(args) {
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

  // const translationsEn = {
  //   firstname: "First Name!",
  //   components:"Components"
  // };

  // const translationsTr = {
  //   firstname: "İsim!",
  //   components:"Bileşenler"
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

  // const { t } = useTranslation();

  // const onChange = (event) => {
  //   i18n.changeLanguage(event.target.value);
  // };

  return (
    <div>
      <Navbar {...args} className="navbar-dark bg-dark">
        <NavbarBrand href="/">Employee Manage Project</NavbarBrand>
{/* 
        <select onChange={() => onChange}>
          <option value="en">EN</option>
          <option value="tr">TR</option>
        </select> */}

        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="me-auto" navbar>
            <NavItem>
              <NavLink href="/components/">Components</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="https://github.com/reactstrap/reactstrap">
                GitHub
              </NavLink>
            </NavItem>
          </Nav>
        </Collapse>
      </Navbar>
    </div>
  );
}

export default Header;

