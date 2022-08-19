import React, { useEffect } from "react";
import "./profile.css";
import Bottom from "./Bottom";
import { Link } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";

function Profile() {
  // const sess = sessionStorage.getItem("userSession");
  // const userdata = JSON.parse(sessionStorage.getItem("userdata"));
  // const loggedInUser = JSON. parse(localStorage. getItem("user"));
  const sess = sessionStorage.getItem("user");
  console.log("data of user");
  console.log(sess);
  console.log("pases data");
  console.log(JSON.parse(sess));
  const loggedInUser = JSON.parse(sess);
  // const foundUser = JSON.parse(loggedInUser);
  // console.log(loggedInUser);

  // useEffect that will run on mount to show notification
  useEffect(() => {
    notify();
  }, []);
  const notify = () =>
    toast.success("Logged in Successfully.", {
      position: toast.POSITION.TOP_CENTER,
      autoClose: 3000,
    });

  return (
    <div>
      <div
        style={{
          // backgroundImage: `url("https://media.istockphoto.com/vectors/woman-with-dog-vector-id1216032293?s=612x612")`,
          backgroundImage:
            "linear-gradient(to right top, #3233, #1b732c, #1332, #5333, #254332)",
        }}
      >
        <div class="container vh-100 w-50">
          <ToastContainer />
          <div class="row d-flex justify-content-left mt-4">
            <div class="col-md-10 mt-5 pt-5">
              <div class=" z-depth-3">
                <div class="col-sm-12 bg-info rounded-left">
                  <div class="card-block text-left  text-white">
                    <i class="fas fa-id-card fa-7x mt-2 mb-3"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row d-flex justify-content-left">
            <div class="col-md-10 ">
              <div class=" z-depth-3">
                <div class="col-sm-12 bg-white rounded-right pb-3">
                  <h3 class=" p-2 text-center font-weight-bold">
                    <b>SELLER PROFILE CARD</b>
                  </h3>
                  <hr class="badge-primary mt-0 " />
                  <div class="row">
                    <div class="col-sm-12">
                      <h3 class="font-weight-bold">
                        {/* Full Name : {sess != null ? loggedInUser.fname : "name"} */}
                        Full Name : {loggedInUser.fname} {loggedInUser.lname}
                      </h3>
                    </div>
                  </div>
                  <hr class="bg-primary" />
                  <div class="row">
                    <div class="col-sm-12">
                      <h3 class="font-weight-bold">
                        {/* Email ID : {sess != null ? userdata.email : "email"} */}
                        Email ID : {loggedInUser.email}
                      </h3>
                    </div>
                  </div>
                  <hr class="bg-primary" />
                  <div class="row">
                    <div class="col-sm-3">
                      <h3 class="font-weight-bold">
                        {/* City:{sess != null ? userdata.city : "city"} */}
                        Phone No : {loggedInUser.phone_no}
                      </h3>
                    </div>
                  </div>
                  <hr class="bg-primary" />
                  <div class="row">
                    <div class="col-sm-12">
                      <h3 class="font-weight-bold">
                        {/* Phone : {sess != null ? userdata.phone : "phone"} */}
                        Aadhar No : {loggedInUser.aadhaar_no}
                      </h3>
                      <hr />
                      <button className="btn btn-primary">
                        <Link to="/addpet" className="text-white">
                          Add Pet
                        </Link>
                      </button>
                      &emsp;
                      <button className="btn btn-primary">
                        <Link to="/userpets" className="text-white">
                          View Pet
                        </Link>
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <Bottom />
    </div>
  );
}

export default Profile;
