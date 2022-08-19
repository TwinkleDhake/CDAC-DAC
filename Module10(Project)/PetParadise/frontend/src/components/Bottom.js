import React from "react";
import "./Home.css";
import { Link, useHistory } from "react-router-dom";

function Bottom() {
  const sess = sessionStorage.getItem("user");
  const loggedInUser = JSON.parse(sess);
  const history = useHistory();

  function toProfile() {
    if (loggedInUser.usertype === 1) {
      history.push("/profile");
    } else if (loggedInUser.usertype === 0) {
      history.push("/buyerprofile");
    }
  }
  return (
    <div>
      <footer class="bg-dark text-white pt-5 pb-4">
        <div class="container text-center text-md-left">
          <div class="row text-center text-md-left">
            <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
              <h5 class="text-uppercase mb-4 font-weight-bold text-warning">
                <i class="fas fa-paw"></i>
                PET PARADISE
              </h5>
              <p style={{ color: "white" }}>
                A platform for all animals and animal lovers. One can buy and
                sell the pet. Help homeless animals,connect to the nearby animal
                shelter. Doctor, trainer, and caretaker for your pet !!!.
              </p>
            </div>

            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
              <h5 class="text-uppercase mb-4 font-weight-bold text-warning">
                Services
              </h5>
              <p>
                <a href="#" class="text-white">
                  Animal Shelter
                </a>
                <br />
                <a href="/allveterinary" class="text-white">
                  Veterinary
                </a>{" "}
                <br />
                <a href="#" class="text-white">
                  Pet Care Taker
                </a>
                <br />
                <a href="alltrainer" class="text-white">
                  Pet Trainer
                </a>
              </p>
            </div>

            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
              <h5 class="text-uppercase mb-4 font-weight-bold text-warning">
                Useful links
              </h5>
              <p>
                <Link to="/home" class="text-white">
                  HOME
                </Link>
              </p>
              <p>
                <Link to="/donate" class="text-white">
                  PETS
                </Link>
              </p>
              <p>
                <Link onClick={toProfile} class="text-white">
                  PROFILE
                </Link>
              </p>
              {/* <p>
                <Link to="/profile" class="text-white">
                  PROFILE
                </Link>
              </p> */}
            </div>

            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
              <h5 class="text-uppercase mb-4 font-weight-bold text-warning">
                Contact
              </h5>
              <p>
                <i class="fa fa-home mr-3"></i>PETPARADISE
              </p>
              <p>
                <i class="fa fa-envelope mr-3"></i>petparadise@gmail.com
              </p>
              <p>
                <i class="fa fa-phone mr-3"></i>+91 999999999
              </p>
              <p>
                <i class="fa fa-phone mr-3"></i>+91 999999999
              </p>
            </div>
          </div>

          <hr class="mb-4" />

          <div
            style={{ justifyContent: "center" }}
            class="row align-items-center"
          >
            <div
              class="col-md-7 col-lg-12 m-auto"
              style={{ justifyContent: "center" }}
            >
              <p>
                Copyright ©2022 All rights reserved by:
                <a href="#">
                  <strong class="text-warning col-sm m-auto">
                    PETPARADISE
                  </strong>
                  <div className="d-flex flex-row-reverse">
                    <i class="fab fa-facebook-square"></i>

                    <i class="fab fa-instagram"></i>

                    <i class="fab fa-twitter"></i>
                  </div>
                </a>
              </p>
            </div>
          </div>
        </div>
      </footer>
    </div>
  );
}

export default Bottom;
