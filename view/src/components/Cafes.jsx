import React, { useEffect, useState } from 'react';
import '../style/ShowCafes.css';
import { useNavigate } from 'react-router-dom';


function CafeCard({ cafe}) {
  const navigate = useNavigate();

  const handleClickedCafe = () => {
    navigate(`/cafe/${cafe.cafe_id}`, { state: { cafe } });
  };
  

  return (
    <div className="cafe-card" onClick={handleClickedCafe}>
      <h3>{cafe.name}</h3>
      <p>Cuisine: {cafe.cuisine}</p>
      <p>{cafe.description}</p>
      <p>Location: {cafe.location}</p>
      <p>Contact: {cafe.contact}</p>
    </div>
  );
}


function Cafes({isOwner}) {
  const [cafes, setCafes] = useState([]);
  const [startIndex, setStartIndex] = useState(0);

  useEffect(() => {
    // Fetch data from the API
    fetch('http://localhost:8080/api/cafe/find')
      .then(response => response.json())
      .then(data => {
        console.log('Fetched Data:', data);
        setCafes(data)
      })
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  const handlePrev = () => {
    setStartIndex(prevIndex => Math.max(prevIndex - 1, 0));
  };

  const handleNext = () => {
    setStartIndex(prevIndex => Math.min(prevIndex + 1, cafes.length - 4));
  };

  return (
    <div className="carousel-container">
      <div className="carousel">
        <div className="card-row">
          {cafes.slice(startIndex, startIndex + 4).map(cafe => (
            <CafeCard key={cafe.cafe_id} cafe={cafe} />
          ))}
        </div>
      </div>
      <div className="controls">
        <button onClick={handlePrev} disabled={startIndex === 0}>
          Prev
        </button>
        <button onClick={handleNext} disabled={startIndex === cafes.length - 4}>
          Next
        </button>
      </div>
    </div>
  );
}

export default Cafes;
