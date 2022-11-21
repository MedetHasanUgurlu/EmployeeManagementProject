import React, { Component } from 'react';
import { Navbar, NavbarBrand } from 'reactstrap';

class Footer extends Component {
    render() {
        return (
            <>
                <div  className='text-center text-lg-left'>
                    <div className='text-center p-3' style={{ backgroundColor: 'rgba(0, 0, 0, 0.2)' }}>
                        &copy; {new Date().getFullYear()} Copyright:{' '}
                        <a className='text-dark' href='https://www.linkedin.com/in/medet-hasan-ugurlu-36041618b/'>
                            MHU.com
                        </a>
                    </div>
                </div>

            </>
        )
    }
}
export default Footer;