import Footer from "./Footer";
import "../App.css";
export default function Support() {
  // useEffect(() => {
  //   if (
  //     sessionStorage.getItem("role") === "null" ||
  //     sessionStorage.getItem("role") != "ADMIN"
  //   ) {
  //     window.location.href = "/login";
  //   }
  // }, []);
  return (
    <div className="bg-success">
      <div class="container-fluid">
        <div class="row p-5">
          <div class="col-md-12">
            <div className="row">
              <div className="col-md-4">
                <div className="single-box">
                  <div className="img-area">
                    <img src="images/Dog3.jpg" alt="aneesh" />
                  </div>
                  <div className="img-text">
                    <h2>Aniket Shinde</h2>
                    <p>
                      Hi I'm Aniket Shinde. I'm currently pursuing Post Gratuate
                      Diploma in CDAC Delhi, I am the Project Lead and my role
                      in the project is Full Stack developer.
                    </p>
                  </div>
                </div>
              </div>

              <div className="col-md-4">
                <div className="single-box">
                  <div className="img-area">
                    <img src="images/vaishuphoto.jpg" alt="chirag" />
                  </div>
                  <div className="img-text">
                    <h2>Vaishali kele</h2>
                    <p>
                      Hi I'mVaishali kele. I'm currently pursuing Post Gratuate
                      Diploma in CDAC Delhi, and my role in the project is Full
                      Stack developer.
                    </p>
                  </div>
                </div>
              </div>

              <div className="col-md-4">
                <div className="single-box">
                  <div className="img-area">
                    <img src="images/Dog3.jpg" alt="gajanan" />
                  </div>
                  <div className="img-text">
                    <h2>Rupesh Malik</h2>
                    <p>
                      Hi I'm Rupesh Malik. I'm currently pursuing Post Gratuate
                      Diploma in CDAC Delhi, and my role in the project is
                      Frontend developer.
                    </p>
                  </div>
                </div>
              </div>

              <div className="col-md-4">
                <div className="single-box">
                  <div className="img-area">
                    <img src="images/Dog3.jpg" alt="pratik" />
                  </div>
                  <div className="img-text">
                    <h2>Twinkle Dhake</h2>
                    <p>
                      Hi I'm Twinkle Dhake. I'm currently pursuing Post Gratuate
                      Diploma in CDAC Delhi, and my role in the project is
                      frontend developer.
                    </p>
                  </div>
                </div>
              </div>

              {/* <div className="col-md-4">
                  <div className="single-box">
                    <div className="img-area">
                      <img
                        src="images/Dog3.jpg"
                        alt="sid"
                      />
                    </div>
                    <div className="img-text">
                      <h2>Kuldeep Raut</h2>
                      <p>
                        Hi I'm Kuldeep Raut. I'm currently pursuing Diploma in
                        CDAC Khaghar, and my role in the project is frontend
                        developer.
                      </p>
                    </div>
                  </div>
                </div> */}
            </div>
          </div>
        </div>
      </div>

      <Footer />
    </div>
  );
}
