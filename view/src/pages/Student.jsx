import React from 'react';
import '../style/Student.css';
import Cafes from '../components/Cafes';

function Student() {
    return (
      <div style={{display:'flex', alignItems: 'center', flexDirection:'column'}}>
        <div className="student-container">
          <div className="background"></div>
          <div className="content">
            <div className="input-container">
              <input type="text" placeholder="Enter any cuisine..." />
            </div>
            <div className="button-container">
              <button>Search</button>
            </div>
          </div>
        </div>
       
        <div className="cafes-container">
            <b>Trending Cafes in your area...</b>
            <Cafes isOwner={false}/>
        </div>
      </div>
    );
  }

export default Student;
