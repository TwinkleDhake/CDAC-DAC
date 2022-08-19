import React from "react";
import "./Cards.css";
import CardItem from "./CardItem";

function Cards() {
  return (
    <div className="cards">
      <h1 className="h1">SELECT YOUR PET!</h1>
      <div className="cards__container">
        <div className="cards__wrapper">
          <ul className="cards__items">
            <CardItem
              src="images/Dog2.jpg"
              text="“Happiness is a warm puppy.”"
              label="Miniature"
              path="/allpets"
            />
            <CardItem
              src="images/Dog3.jpg"
              text="“The best way to get a puppy is to beg for a baby brother– and they’ll settle for a puppy every time.”"
              label="british bulldog"
              path="/allpets"
            />
          </ul>
          <ul className="cards__items">
            <CardItem
              src="images/Dogcat1.jpg"
              text="“An animal's eyes have the power to speak a great language.”"
              label="German shepherd & Bengal cat"
              path="/allpets"
            />
            <CardItem
              src="images/Cat1.jpg"
              text="“Just watching my cats can make me happy.” "
              label="Persian Cat"
              path="/allpets"
            />
            <CardItem
              src="images/Dogcat2.jpg"
              text="“Animals are such agreeable friends—they ask no questions; they pass no criticisms.”"
              label="Lab & Ragdoll"
              path="/allpets"
            />
          </ul>
          <div>
            <a href="allpetcaretaker">
              <img src="images/Dogcat5.jpg" alt="Pet Care" />
              <h2 className="h2">Pet Care</h2>
            </a>
            <br />
            <p>
              Are you a new pet parent, or looking to bolster your pet care
              skills? Read on for grooming guides, nutrition information, safety
              tips and more.
            </p>
          </div>
          <div>
            <br />
            <a href="allveterinary">
              <img src="images/vat1.jpg" alt="Pet Care" />
              <h2 className="h2">Pet Veterinary</h2>
            </a>
            <br />
            <p>
              Welcome to the new Pet Paradise Health Center. WebMD veterinary
              experts provide comprehensive information about pet health care,
              offer nutrition and feeding
            </p>
          </div>
          <div>
            <br />
            <a href="alltrainer">
              <img src="images/pettrani1.jpeg" alt="Pet Care" />
              <h2 className="h2">Pet Trainer</h2>
            </a>
            <br />
            <p>
              Train Your Own Dog The first step in your journey should be
              training your own dog. If you don’t currently own a dog, find one
              you can spend a lot of time with so you can build a regular
              training routine. Don’t just teach the basics like “sit” or
              “down.” Teach advanced skills too, such as staying put with the
              added challenge of distance and distractions. The AKC Canine Good
              Citizen test is an excellent goal to work towards. Also consider
              taking up a dog sport with your dog so you can really dig into the
              technical aspects of training like timing, rate of reinforcement,
              and reward placement. Finally, modify any problem behaviors as you
              encounter them.
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Cards;
