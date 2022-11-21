import React, { useState } from 'react';
import ReactDOM from 'react-dom/client';

import Header from './conponents/Header';
import Footer from './conponents/Footer';
import EmployeeList from './EmployeeComponents/EmployeeList';
import CreateEmployee from './EmployeeComponents/CreateEmployee';
import ViewEmployee from './EmployeeComponents/ViewEmployee';
import {
  Route, Routes,
  BrowserRouter,
} from "react-router-dom";


const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(

  <BrowserRouter>
    <Header />
    
    <Routes>
      <Route path='/'exact element={<EmployeeList/>} ></Route>
      <Route path='/employees' element={<EmployeeList/>} ></Route>
      <Route path='/employee-add/:id' element={<CreateEmployee/>} ></Route>
      <Route path='/employee-view/:id' element={<ViewEmployee/>} ></Route>
    </Routes>
    <Footer />
  </BrowserRouter>

);

