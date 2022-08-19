import React, { useState, useEffect } from "react";
import { Button } from "./Button";
import { Link, useHistory } from "react-router-dom";
import "./Navbar.css";
import { NavDropdown } from "react-bootstrap";

function Navbar() {
  const sess = sessionStorage.getItem("user");
  const loggedInUser = JSON.parse(sess);
  const history = useHistory();

  function logOut() {
    sessionStorage.removeItem("user");
    history.push("/login");
    window.location.reload(false);
  }
  function toProfile() {
    if (loggedInUser.usertype === 1) {
      history.push("/profile");
    } else if (loggedInUser.usertype === 0) {
      history.push("/buyerprofile");
    }
  }

  const [click, setClick] = useState(false);
  const [button, setButton] = useState(true);

  const handleClick = () => setClick(!click);
  const closeMobileMenu = () => setClick(false);

  const showButton = () => {
    if (window.innerWidth <= 960) {
      setButton(false);
    } else {
      setButton(true);
    }
  };

  useEffect(() => {
    showButton();
  }, []);

  window.addEventListener("resize", showButton);

  return (
    <>
      <head>
        <link
          rel="stylesheet"
          href="font-awesome-4.7.0\css\font-awesome.min.css"
        />
      </head>
      <nav className="navbar">
        <div className="navbar-container">
          <Link to="/" className="navbar-logo" onClick={closeMobileMenu}>
            <i class="fa fa-paw" aria-hidden="true"></i>
            PetParadise
          </Link>
          <div className="menu-icon" onClick={handleClick}>
            <i className={click ? "fas fa-times" : "fas fa-bars"} />
          </div>
          <ul className={click ? "nav-menu active" : "nav-menu"}>
            <li className="nav-item">
              <Link to="/" className="nav-links" onClick={closeMobileMenu}>
                Home
              </Link>
            </li>
            <li className="nav-item">
              <Link
                to="/allpets"
                className="nav-links"
                onClick={closeMobileMenu}
              >
                Buy
              </Link>
            </li>
            {/* <li className="nav-item">
              <Link to="/#" className="nav-links" onClick={closeMobileMenu}>
                Sell
              </Link>
            </li> */}
            <li className="nav-item">
              <Link
                to="/alltrainer"
                className="nav-links"
                onClick={closeMobileMenu}
              >
                Trainer
              </Link>
            </li>
            <li className="nav-item">
              <Link
                to="/allAnimalShelter"
                className="nav-links"
                onClick={closeMobileMenu}
              >
                Shelter
              </Link>
            </li>
            <li className="nav-item">
              <Link
                to="/allpetcaretaker"
                className="nav-links"
                onClick={closeMobileMenu}
              >
                CareTaker
              </Link>
            </li>
            <li className="nav-item">
              <Link
                to="/allveterinary"
                className="nav-links"
                onClick={closeMobileMenu}
              >
                Veterinary
              </Link>
            </li>
            <li>
              <Link
                to="/signup"
                className="nav-links"
                onClick={closeMobileMenu}
              >
                SignUp
              </Link>
            </li>
            <li>
              <Link to="/login" className="nav-links" onClick={closeMobileMenu}>
                SignIn
              </Link>
            </li>
            {sessionStorage.getItem("user") ? (
              <li className="nav-item">
                <NavDropdown title={loggedInUser && loggedInUser.username}>
                  <NavDropdown.Item onClick={toProfile}>
                    Profile
                  </NavDropdown.Item>
                  <NavDropdown.Item onClick={logOut}>Logout</NavDropdown.Item>
                </NavDropdown>
              </li>
            ) : null}
          </ul>
          {/* {button && <Button buttonStyle="btn--outline">SIGN UP</Button>} */}
        </div>
      </nav>
    </>
  );
}

export default Navbar;
