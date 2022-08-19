import React, { useState } from "react";
// import { BrowserRouter as Router, Route } from "react-router-dom";
import axios from "axios";
import { Redirect } from "react-router-dom";
import Footer from "./Bottom";
// import { FaUser, FaUnlock } from "react-icons/fa";
import ReCAPTCHA from "react-google-recaptcha";

const Login = () => {
  //functional component
  const [login, setLogin] = useState({ username: "", password: "" });
  const [isSignUp, setisSignUp] = useState(false);

  let user;

  const handleOnChange = (e) => {
    setisSignUp(true);
  };

  const handleChange = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setLogin({ ...login, [name]: value });
    // isSignUp({ isVerified: false });
  };

  const handleSubmit = (e) => {
    e.preventDefault(); //to not reload the page

    if (login.username && login.password) {
      axios
        .post("http://localhost:8080/api/registration/login", {
          username: login.username,
          password: login.password,
        })
        .then((response) => {
          sessionStorage.setItem("user", JSON.stringify(response.data)); //to store the data in frontEnd we used sessionStorage
          user = response.data;
          console.log(user + "**********************");

          var usertype = response.data.usertype;
          console.log(usertype + "////////////");
          console.log(user + "*********");
          if (usertype === 1) {
            // return <Redirect to="/profile" />;
            window.location.href = "http://localhost:3000/profile";
            console.log("Seller");
          } else if (usertype === 0) {
            //  return <Redirect to="/buyerprofile" />;
            window.location.href = "http://localhost:3000/buyerprofile";
            console.log("Buyer");
          }
        })
        .catch((error) => {
          console.log(error.response);
        });
      setLogin({ username: "", password: "" });
    }
  };
  return (
    <>
      <head>
        <link
          rel="stylesheet"
          href="font-awesome-4.7.0\css\font-awesome.min.css"
        />
      </head>
      <section className="vh-100">
        <div className="container h-100">
          <div className="row d-flex justify-content-center align-items-center h-100">
            <div className="col-lg-8 col-xl-9">
              <div className="card text-black" style={{ borderRadius: "25px" }}>
                <div className="card-body p-md-5">
                  <div className="row justify-content-center">
                    <div className="col-md-10 col-lg-6 col-xl-7 order-2 order-lg-1">
                      <p className="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                        Login
                      </p>

                      <form onSubmit={handleChange} className="mx-1 mx-md-4">
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i
                            class="fa fa-user-circle fa-lg"
                            aria-hidden="true"
                          ></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="username"
                              name="username"
                              className="form-control"
                              placeholder="User Name"
                              autoComplete="off"
                              value={login.username}
                              onChange={handleChange}
                            />
                            {/* {errors.username &&<p className="error">{errors.username}</p>} */}
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i class="fa fa-unlock fa-lg" aria-hidden="true"></i>{" "}
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="password"
                              id="password"
                              name="password"
                              className="form-control"
                              placeholder="Password"
                              autoComplete="off"
                              value={login.password}
                              onChange={handleChange}
                            />
                            {/* {errors.password &&<p className="error">{errors.password}</p>} */}
                          </div>
                        </div>
                        <div className="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                          <ReCAPTCHA
                            sitekey="6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI"
                            onChange={handleOnChange}
                          />
                        </div>
                        <div className="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                          <button
                            disabled={!isSignUp}
                            type="submit"
                            className="btn btn-primary btn-lg"
                            onClick={handleSubmit}
                          >
                            Login
                          </button>
                        </div>
                      </form>
                    </div>
                    <div className="col-md-10 col-lg-6 col-xl-5 d-flex align-items-center order-1 order-lg-2">
                      <img
                        src="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/9aab9a1f-d227-4471-9f12-fa4a5b348f90/d3aq9rs-1f2f48c9-d089-40a2-b245-b60054cb9bb8.jpg/v1/fill/w_900,h_1313,q_75,strp/pet_stack_by_robthedoodler_d3aq9rs-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTMxMyIsInBhdGgiOiJcL2ZcLzlhYWI5YTFmLWQyMjctNDQ3MS05ZjEyLWZhNGE1YjM0OGY5MFwvZDNhcTlycy0xZjJmNDhjOS1kMDg5LTQwYTItYjI0NS1iNjAwNTRjYjliYjguanBnIiwid2lkdGgiOiI8PTkwMCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.gmX2L-eLvNTJqupcJylhVOmZxCvyYqOghjHOS3SKWOY"
                        className="img-fluid"
                        alt="Sample image"
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <Footer />
    </>
  );
};

export default Login;
