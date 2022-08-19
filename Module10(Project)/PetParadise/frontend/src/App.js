import "./App.css";
import Login from "./components/Login";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import React from "react";
import Home from "./components/pages/Home";
import Navbar from "./components/Navbar";
import Sell from "./components/pages/Sell";
import Petcare from "./components/pages/Petcare";
import Petveterinary from "./components/pages/Petveterinary";
import Pettranner from "./components/pages/Pettranner";
import SignUp from "./components/pages/SignUp";
import UserForm from "./components/RegValidations";
import BuyerProfile from "./components/BuyerProfile";
import Profile from "./components/Profile";
import AddPet from "./components/AddPet";
import UserPet from "./components/UserPet";
import BuyerPetDisp from "./components/BuyerPetsDisp";
import PetCards from "./components/PetCards";
import SellerInfo from "./components/SellerInfo";
import Alltrainer from "./components/pet_trainer/Alltrainer";
import SaveTrainer from "./components/pet_trainer/SaveTrainer";
import Trainer from "./components/pet_trainer/SaveTrainer";
import LoginReg from "./components/LoginReg";
import SavePetVet from "./components/pet_vet/SavePetVet";
import AllPetVet from "./components/pet_vet/AllPetVet";
import Veterinary from "./components/pet_vet/Veterinary";
import AllAnimalShelter from "./components/animal_shelter/AllAnimalShelter";
import Pet_Caretakers from "./components/pet_caretaker/SavePet_Caretakers";
import AllPetCaretaker from "./components/pet_caretaker/AllPetCaretaker";
import SaveAnimal_Shelter from "./components/animal_shelter/SaveAnimal_Shelter";
import Support from "./components/Support";

function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Switch>
          <Route path="/" exact component={Home} />
          <Route path="/login" component={Login} />
          <Route path="/sell" component={Sell} />
          <Route path="/signup" component={UserForm} />
          <Route path="/buyerprofile" component={BuyerProfile} />
          <Route path="/profile" component={Profile} />
          <Route path="/addpet" component={AddPet} />
          <Route path="/userpets" component={UserPet} />
          <Route path="/buyerpetdisp" component={BuyerPetDisp} />
          <Route path="/allpets" component={PetCards} />
          <Route path="/sellerinfo" component={SellerInfo} />
          <Route path="/alltrainer" component={Alltrainer} />
          <Route path="/savetrainer" component={SaveTrainer} />
          <Route path="/savetrainer" component={Trainer} />
          <Route path="/loginreg" component={LoginReg} />
          <Route path="/saveveterinary" component={SavePetVet} />
          <Route path="/allveterinary" component={AllPetVet} />
          <Route path="/saveveterinary" component={Veterinary} />
          <Route path="/allAnimalShelter" component={AllAnimalShelter} />
          <Route path="/saveanimalshelter" component={SaveAnimal_Shelter} />
          <Route path="/allpetcaretaker" component={AllPetCaretaker} />
          <Route path="/savepetcaretaker" component={Pet_Caretakers} />
          <Route path="/petcare" component={Petcare} />
          <Route path="/Petveterinary" component={Petveterinary} />
          <Route path="/pettranner" component={Pettranner} />
          <Route path="/Support" component={Support} />
        </Switch>
      </Router>
    </>
  );
}

export default App;
