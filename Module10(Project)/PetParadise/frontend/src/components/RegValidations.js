import React, { Component } from "react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import axios from "axios";
import Footer from "./Bottom";
import ReCAPTCHA from "react-google-recaptcha";

// captcha(value) {
//   console.log("Captcha value:", value);
//   this.setState({isVerified: true });
// }

// const handleOnChange = (e) => {
//   setisSignUp(true);
// };

const regExp = RegExp(/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/);

const formValid = ({ isError, ...rest }) => {
  let isValid = false;
  Object.values(isError).forEach((val) => {
    if (val.length > 0) {
      isValid = false;
    } else {
      isValid = true;
    }
  });
  Object.values(rest).forEach((val) => {
    if (val === null) {
      isValid = false;
    } else {
      isValid = true;
    }
  });
  return isValid;
};

export default class UserForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fname: "",
      lname: "",
      email: "",
      phono_no: "",
      adhar_no: "",
      username: "",
      usertype: "",
      password: "",
      // isVerified: false,
      isError: {
        fname: "",
        lname: "",
        email: "",
        phono_no: "",
        adhar_no: "",
        username: "",
        usertype: "",
        password: "",
      },
    };
  }

  onSubmit = (e) => {
    e.preventDefault();
    if (
      formValid(this.state)
      //   &&
      //   this.state.fname &&
      //   this.state.lname &&
      //   this.state.email &&
      //   this.state.phono_no &&
      //   this.state.adhar_no &&
      //   this.state.username &&
      //   this.state.usertype &&
      //   this.state.password
    ) {
      axios
        .post("http://localhost:8080/api/registration/signup", {
          aadhaar_no: this.state.adhar_no,
          email: this.state.email,
          fname: this.state.fname,
          lname: this.state.lname,
          password: this.state.password,
          phone_no: this.state.phono_no,
          username: this.state.username,
          usertype: this.state.usertype,
        })
        .then((response) => {
          console.log(response.data);
          toast.success("Registration successfully Completed", {
            position: "bottom-center",
            autoClose: false,
          });
          this.setState({
            fname: "",
            lname: "",
            email: "",
            phono_no: "",
            adhar_no: "",
            username: "",
            usertype: "",
            password: "",
          });
        })
        .catch((error) => {
          console.log(error.response);
          toast.error("Server unreachable..", {
            position: "bottom-center",
            autoClose: false,
          });
        });
      console.log(this.state);
    } else {
      console.log("Form is invalid!");
    }
  };

  formValChange = (e) => {
    e.preventDefault();
    const { name, value } = e.target;
    let isError = { ...this.state.isError };
    switch (name) {
      case "fname":
        isError.fname =
          value.length < 3 ? "Atleast 3 characaters required" : "";
        break;
      case "lname":
        isError.lname =
          value.length < 3 ? "Atleast 3 characaters required" : "";
        break;
      case "email":
        isError.email = regExp.test(value) ? "" : "Email address is invalid";
        break;
      case "phono_no":
        isError.phono_no =
          value.length < 10 ? "Atleast 10 digits required" : "";
        break;
      case "adhar_no":
        isError.adhar_no =
          value.length < 11 && value.length > 13 ? "must be 12 numbers" : "";
        break;
      case "username":
        isError.username =
          value.length < 3 ? "Atleast 3 characaters required" : "";
        break;
      case "usertype":
        isError.usertype = value < 2 && value > -1 ? "must be 0 or 1" : "";
        break;
      case "password":
        isError.password =
          value.length < 6 ? "Atleast 6 characaters required" : "";
        break;
      default:
        break;
    }
    this.setState({
      isError,
      [name]: value,
    });
  };
  notify = () =>
    toast.info("Welcome to PETPARADISE !", {
      position: "top-center",
      autoClose: 5000,
    });

  render() {
    const { isError } = this.state;
    return (
      <>
        <div className="container h-100">
          <ToastContainer />
          <div className="row d-flex justify-content-center align-items-center h-100">
            <div className="col-lg-8 col-xl-9">
              <div className="card text-black" style={{ borderRadius: "25px" }}>
                <div className="card-body p-md-5">
                  <div className="row justify-content-center">
                    <div className="col-md-10 col-lg-6 col-xl-7 order-2 order-lg-1">
                      <p className="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                        Registration
                      </p>
                      <form
                        onSubmit={this.onSubmit}
                        noValidate
                        className="mx-1 mx-md-4"
                      >
                        <div className="d-flex flex-row align-items-center mb-4">
                          {" "}
                          <i
                            class="fa fa-user-circle fa-lg"
                            aria-hidden="true"
                          ></i>{" "}
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              className={
                                isError.fname.length > 0
                                  ? "is-invalid form-control"
                                  : "form-control"
                              }
                              name="fname"
                              placeholder="First Name"
                              onChange={this.formValChange}
                            />
                            {isError.fname.length > 0 && (
                              <span className="invalid-feedback">
                                {isError.fname}
                              </span>
                            )}
                          </div>
                        </div>
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i
                            class="fa fa-user-circle fa-lg"
                            aria-hidden="true"
                          ></i>{" "}
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              className={
                                isError.lname.length > 0
                                  ? "is-invalid form-control"
                                  : "form-control"
                              }
                              name="lname"
                              placeholder="Last Name"
                              onChange={this.formValChange}
                            />
                            {isError.lname.length > 0 && (
                              <span className="invalid-feedback">
                                {isError.lname}
                              </span>
                            )}
                          </div>
                        </div>
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i
                            class="fa fa-envelope fa-lg"
                            aria-hidden="true"
                          ></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="email"
                              className={
                                isError.email.length > 0
                                  ? "is-invalid form-control"
                                  : "form-control"
                              }
                              name="email"
                              placeholder="email"
                              onChange={this.formValChange}
                            />
                            {isError.email.length > 0 && (
                              <span className="invalid-feedback">
                                {isError.email}
                              </span>
                            )}
                          </div>
                        </div>
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i class="fa fa-phone fa-lg" aria-hidden="true"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="number"
                              className={
                                isError.phono_no.length > 0
                                  ? "is-invalid form-control"
                                  : "form-control"
                              }
                              name="phono_no"
                              placeholder="Phone Number"
                              onChange={this.formValChange}
                            />
                            {isError.phono_no.length > 0 && (
                              <span className="invalid-feedback">
                                {isError.phono_no}
                              </span>
                            )}
                          </div>
                        </div>
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i
                            class="fa fa-address-card fa-lg"
                            aria-hidden="true"
                          ></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="number"
                              className={
                                isError.adhar_no.length > 0
                                  ? "is-invalid form-control"
                                  : "form-control"
                              }
                              name="adhar_no"
                              placeholder="aadhaar_no"
                              onChange={this.formValChange}
                            />
                            {isError.adhar_no.length > 0 && (
                              <span className="invalid-feedback">
                                {isError.adhar_no}
                              </span>
                            )}
                          </div>
                        </div>
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i
                            class="fa fa-user-circle fa-lg"
                            aria-hidden="true"
                          ></i>{" "}
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              className={
                                isError.username.length > 0
                                  ? "is-invalid form-control"
                                  : "form-control"
                              }
                              name="username"
                              placeholder="User Name"
                              onChange={this.formValChange}
                            />
                            {isError.username.length > 0 && (
                              <span className="invalid-feedback">
                                {isError.username}
                              </span>
                            )}
                          </div>
                        </div>
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i
                            class="fa fa-user-circle fa-lg"
                            aria-hidden="true"
                          ></i>{" "}
                          <div className="form-outline flex-fill mb-0">
                            {/* <label>0 for Buyer & 1 for Seller</label> */}
                            <input
                              type="number"
                              className={
                                isError.usertype.value > -1 &&
                                isError.usertype.value < 2
                                  ? "is-invalid form-control"
                                  : "form-control"
                              }
                              name="usertype"
                              autoComplete="off"
                              placeholder="User Type [Buyer->0/Seller->1]"
                              onChange={this.formValChange}
                            />
                            <p class="msg">
                              * Please Input 0 for Buyer & 1 for Seller.
                            </p>
                            {isError.usertype.value > -1 &&
                              isError.usertype.value < 2 && (
                                <span className="invalid-feedback">
                                  {isError.usertype}
                                </span>
                              )}
                          </div>
                        </div>
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i class="fa fa-unlock fa-lg" aria-hidden="true"></i>{" "}
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="password"
                              className={
                                isError.password.length > 0
                                  ? "is-invalid form-control"
                                  : "form-control"
                              }
                              name="password"
                              placeholder="Password"
                              onChange={this.formValChange}
                            />
                            {isError.password.length > 0 && (
                              <span className="invalid-feedback">
                                {isError.password}
                              </span>
                            )}
                          </div>
                        </div>
                        {/* <div className="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                          <ReCAPTCHA
                            sitekey="6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI"
                            onChange={handleOnChange}
                          />
                        </div> */}
                        <div className="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                          <button
                            // disabled={!this.state.isVerified}
                            // disabled={!isSignUp}
                            type="submit"
                            className="btn btn-primary btn-lg"
                            onClick={this.notify}
                          >
                            Register
                          </button>
                        </div>
                      </form>
                    </div>
                    <div className="col-md-10 col-lg-6 col-xl-5 d-flex align-items-center order-1 order-lg-2">
                      <img
                        src="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/9aab9a1f-d227-4471-9f12-fa4a5b348f90/d3aq9rs-1f2f48c9-d089-40a2-b245-b60054cb9bb8.jpg/v1/fill/w_900,h_1313,q_75,strp/pet_stack_by_robthedoodler_d3aq9rs-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTMxMyIsInBhdGgiOiJcL2ZcLzlhYWI5YTFmLWQyMjctNDQ3MS05ZjEyLWZhNGE1YjM0OGY5MFwvZDNhcTlycy0xZjJmNDhjOS1kMDg5LTQwYTItYjI0NS1iNjAwNTRjYjliYjguanBnIiwid2lkdGgiOiI8PTkwMCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.gmX2L-eLvNTJqupcJylhVOmZxCvyYqOghjHOS3SKWOY"
                        className="img-fluid"
                        alt="My Awesome Img"
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <Footer />
      </>
    );
  }
}
