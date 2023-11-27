import React from 'react';
import '../style/ShowCafes.css';

function CafeCard({ cafe }) {
  return (
    <div className="cafe-card">
      <h3>{cafe.name}</h3>
      <p>Cuisine: {cafe.cuisine}</p>
      <p>{cafe.description}</p>
      <p>Location: {cafe.location}</p>
      <p>Contact: {cafe.contact}</p>
    </div>
  );
}

function Cafes() {

    const cafes = [
        {
            "cafe_id": 0,
            "name": "Italian Cafe",
            "cuisine": "Italian",
            "description": "A cozy cafe serving delicious Italian cuisine.",
            "location": "123 Main Street",
            "contact": "123-456-7890"
        },
        {
            "cafe_id": 919643860344995841,
            "name": "Coffee Shop",
            "cuisine": "Coffee",
            "description": "A cozy cafe serving delicious Coffee.",
            "location": "223 Main Street",
            "contact": "511-236-8920"
        },
        {
            "cafe_id": 919644030013341697,
            "name": "Cozy Coffee Haven",
            "cuisine": "Coffee Shop",
            "description": "A comfortable and relaxing coffee shop with a variety of coffee blends.",
            "location": "456 Oak Street",
            "contact": "555-1234"
        },
        {
            "cafe_id": 919648317193191425,
            "name": "Pizza place",
            "cuisine": "Pizza Shop",
            "description": "Delicious pizza place.",
            "location": "222 Walnut Street",
            "contact": "123-234"
        }
    ]

  return (
    <div className="carousel-container">
      {cafes.map(cafe => (
        <CafeCard key={cafe.cafe_id} cafe={cafe} />
      ))}
    </div>
  );
}

export default Cafes;
