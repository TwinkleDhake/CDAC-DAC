
import TrainerCards from "./TrainerCards";
import { Link } from "react-router-dom";
import Bottom from "../Bottom";


const Alltrainer = () => {
  return (
    <>
      <div>
        <h1 className=" mb-3">Trainer</h1>
      </div>
      <button type="button" class="btn btn-dark mb-3 justify-content-center">
        <Link to="/savetrainer">Register As Trainer</Link>
      </button>
      <div>
        <TrainerCards />
      </div>
      <Bottom />
    </>
  );
};

export default Alltrainer;
