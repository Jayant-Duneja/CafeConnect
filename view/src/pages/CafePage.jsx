import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import '../style/Menu.css';

function CafePage() {
  const { state } = useLocation();
  const cafeData = state?.cafe;
  const isOwner = state?.isOwner; // TODO: Implement Owner page
  const [menuItems, setMenuItems] = useState([]);
  const [currentMenuItemIndex, setCurrentMenuItemIndex] = useState(0);

  useEffect(() => {
    const fetchMenuData = async () => {
      try {
        const response = await fetch(`http://localhost:8080/api/menu/find/${cafeData.cafe_id}`);
        const data = await response.json();
        setMenuItems(data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    if (cafeData) {
      fetchMenuData();
    }
  }, [cafeData]);

  const handlePrevMenuItem = () => {
    setCurrentMenuItemIndex((prevIndex) => Math.max(prevIndex - 1, 0));
  };

  const handleNextMenuItem = () => {
    setCurrentMenuItemIndex((prevIndex) =>
      Math.min(prevIndex + 1, menuItems.length - 1)
    );
  };

  return (
    <div className="cafe-page-container">
      {cafeData ? (
        <div className="cafe-info">
          <h2>
            {cafeData.name} {cafeData.name.includes('Coffee') ? '\u2615' : null}
          </h2>
          <div className="location-contact">
            <p>
              <b>Location</b>: {cafeData.location}
            </p>
            <p style={{ marginLeft: '10px' }}>
              <b>Contact</b>: {cafeData.contact}
            </p>
          </div>
        </div>
      ) : (
        <div>Loading...</div>
      )}

      <h3>Menu</h3>
      {Array.isArray(menuItems) && menuItems.length > 0 ? (
        <div className="carousel-container">
          <div className="carousel">
            {menuItems.slice(currentMenuItemIndex, currentMenuItemIndex + 3).map((menuItem, index) => (
              <div className="card-row" key={index} style={{marginRight:'20px'}}>
                <div className="menu-item">
                  <h3>{menuItem.name}</h3>
                  <p style={{ whiteSpace: 'pre-line' }}>{menuItem.description}</p>
                  <p>${menuItem.price}</p>
                </div>
              </div>
            ))}
          </div>
          <div className="controls">
            <button onClick={handlePrevMenuItem} disabled={currentMenuItemIndex === 0}>
              Prev
            </button>
            <button
              onClick={handleNextMenuItem}
              disabled={currentMenuItemIndex + 3 >= menuItems.length}
            >
              Next
            </button>
          </div>
        </div>
      ) : (
        <div>No menu items available</div>
      )}
    </div>
  );
}

export default CafePage;
