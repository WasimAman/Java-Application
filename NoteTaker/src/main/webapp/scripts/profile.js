document.addEventListener("DOMContentLoaded", function() {
  var userBtns = document.querySelectorAll('.user-btn');
  
  userBtns.forEach(function(btn) {
    btn.addEventListener('click', function() {
      // Remove active class from all user-btn elements
      userBtns.forEach(function(btn) {
        btn.classList.remove('active');
      });
      
      // Add active class to the clicked user-btn element
      this.classList.add('active');
      
      // Store the ID of the active button in session storage
      sessionStorage.setItem('activeButton', this.id);
    });
  });
  
  // Apply active state when page loads
  var activeButtonId = sessionStorage.getItem('activeButton');
  if (activeButtonId) {
    var activeButton = document.getElementById(activeButtonId);
    if (activeButton) {
      activeButton.classList.add('active');
    }
  }
});
