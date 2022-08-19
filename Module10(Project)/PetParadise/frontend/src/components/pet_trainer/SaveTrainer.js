import React, { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const SaveTrainer = () => {
  const [trainner, settrainner] = useState({
    trainnerName: "",
    trainningCenterName: "",
    address: "",
    phone: "",
    description: "",
  });
  const [people, setPeople] = useState([]);
  const handleChange = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    settrainner({ ...trainner, [name]: value });
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    if (
      trainner.trainnerName &&
      trainner.trainningCenterName &&
      trainner.address &&
      trainner.phone &&
      trainner.description
    ) {
      axios
        .post("http://localhost:8080/api/trainer/savetrainer", {
          name: trainner.trainnerName,
          center_name: trainner.trainningCenterName,
          phone: trainner.phone,
          address: trainner.address,
          description: trainner.description,
        })
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error.response);
        });
      settrainner({
        trainnerName: "",
        trainningCenterName: "",
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
                        Trainner's info
                      </p>

                      <form className="mx-1 mx-md-4">
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i className="fas fa-user fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="trainnerName"
                              name="trainnerName"
                              className="form-control"
                              placeholder="Trainner Name"
                              value={trainner.trainnerName}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i className="fas fa-hotel fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="trainningCenterName"
                              name="trainningCenterName"
                              className="form-control"
                              placeholder="Trainning Center Name"
                              value={trainner.trainningCenterName}
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
                              value={trainner.address}
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
                              value={trainner.phone}
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
                              value={trainner.description}
                              onChange={handleChange}
                            />
                          </div>
                        </div>
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i
                            class="fa fa-picture-o fa-lg"
                            aria-hidden="true"
                          ></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="file"
                              id="img"
                              name="img"
                              className="form-control"
                              placeholder="Your Image"
                              accept="image/*"
                              value={trainner.img}
                            />
                          </div>
                        </div>
                        <div className="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                          <button
                            type="submit"
                            className="btn btn-primary btn-lg"
                            onClick={handleSubmit}
                          >
                            <Link to="/alltrainer" className="text-white">
                              Register
                            </Link>
                          </button>
                        </div>
                      </form>
                    </div>
                    <div className="col-md-10 col-lg-6 col-xl-5 d-flex align-items-center order-1 order-lg-2">
                      <img
                        src="https://www.clipartkey.com/mpngs/m/193-1933005_graphic-of-turkey-trot-character-dog-walker-dog.png"
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

      {people.map((person) => {
        const {
          id,
          trainnerName,
          trainningCenterName,
          address,
          phone,
          description,
        } = person;
        return (
          <div key={id}>
            <h4>{trainnerName}</h4>
            <p>{trainningCenterName}</p>
            <p>{address}</p>
            <p>{phone}</p>
            <p>{description}</p>
          </div>
        );
      })}
    </>
  );
};

export default SaveTrainer;
