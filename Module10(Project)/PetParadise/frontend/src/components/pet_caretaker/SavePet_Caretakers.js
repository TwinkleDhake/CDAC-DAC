import React, { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const SavePet_Caretakers = () => {
  const [caretaker, setCaretaker] = useState({
    caretakerName: "",
    careCenterName: "",
    address: "",
    phone: "",
    description: "",
  });
  const [people, setPeople] = useState([]);
  const handleChange = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setCaretaker({ ...caretaker, [name]: value });
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(caretaker.caretakerName);
    if (
      caretaker.caretakerName &&
      caretaker.careCenterName &&
      caretaker.address &&
      caretaker.phone &&
      caretaker.description
    ) {
      console.log(caretaker.caretakerName);
      axios
        .post("http://localhost:8080/api/petcaretaker/savepetcaretaker", {
          name: caretaker.caretakerName,
          center_name: caretaker.careCenterName,
          phone_no: caretaker.phone,
          address: caretaker.address,
          description: caretaker.description,
        })
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error.response);
        });
      setCaretaker({
        caretakerName: "",
        careCenterName: "",
        address: "",
        phone: "",
        description: "",
      });
    }
  };
  return (
    <>
      <section className="vh-100">
        <div className="container h-100">
          <div className="row d-flex justify-content-center align-items-center h-100">
            <div className="col-lg-8 col-xl-9">
              <div className="card text-black" style={{ borderRadius: "25px" }}>
                <div className="card-body p-md-5">
                  <div className="row justify-content-center">
                    <div className="col-md-10 col-lg-6 col-xl-7 order-2 order-lg-1">
                      <p className="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                        CareTaker's info
                      </p>

                      <form className="mx-1 mx-md-4">
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i className="fas fa-user fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="caretakerName"
                              name="caretakerName"
                              className="form-control"
                              placeholder="CareTaker Name"
                              value={caretaker.caretakerName}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i className="fas fa-hotel fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="careCenterName"
                              name="careCenterName"
                              className="form-control"
                              placeholder="CareCenter Name"
                              value={caretaker.careCenterName}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i className="fas fa-home fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="address"
                              name="address"
                              className="form-control"
                              placeholder="Address"
                              value={caretaker.address}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-phone fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="number"
                              id="phone"
                              name="phone"
                              className="form-control"
                              placeholder="Phone No"
                              value={caretaker.phone}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-inbox fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="description"
                              name="description"
                              className="form-control"
                              placeholder="Description"
                              value={caretaker.description}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                          <button
                            type="submit"
                            className="btn btn-primary btn-lg"
                            onClick={handleSubmit}
                          >
                            Good to Go!!
                          </button>
                        </div>
                      </form>
                    </div>
                    <div className="col-md-10 col-lg-6 col-xl-5 d-flex align-items-center order-1 order-lg-2">
                      <img
                        src="https://thumbs.dreamstime.com/b/pet-sitter-29050298.jpg"
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

    
    </>
  );
};

export default SavePet_Caretakers;
