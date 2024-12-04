// Select elements
const homeButton = document.querySelector('.home-icon');
const navMenu = document.querySelector('.nav-menu');
const searchButton = document.querySelector('#search-button'); // Updated selector for button
const searchInput = document.querySelector('.search-input');

// Toggle navigation menu
homeButton.addEventListener('click', function () {
    navMenu.style.display = navMenu.style.display === 'none' || navMenu.style.display === '' ? 'block' : 'none';
});

// Search functionality
searchButton.addEventListener('click', function () {
    const searchTerm = searchInput.value.trim().toLowerCase();
    const allSections = document.querySelectorAll('section');
    
    allSections.forEach(section => {
        section.style.display = 'none'; // Hide all sections
    });

    if (searchTerm.includes('adopt')) {
        document.querySelector('.intro-section').style.display = 'block'; // Show specific section
    } else if (searchTerm.includes('search')) {
        alert('Search functionality is not yet implemented!');
    } else {
        alert('No results found for your search.');
    }

    // Update counts after search
    updateAdoptionCounts();
});

// Accordion functionality
document.querySelectorAll('.accordion').forEach(button => {
    button.addEventListener('click', () => {
        // Toggle active class on clicked button
        button.classList.toggle('active');

        // Toggle the associated panel
        const panel = button.nextElementSibling;
        if (panel.style.maxHeight) {
            panel.style.maxHeight = null; // Collapse
            button.querySelector('.icon').textContent = '+'; // Change icon to "+"
        } else {
            panel.style.maxHeight = panel.scrollHeight + "px"; // Expand
            button.querySelector('.icon').textContent = '-'; // Change icon to "-"
        }
    });
});

// Counters for adoption, dogs, fosters
let adoptionApplicationsCount = 0;
let dogsAdoptedCount = 0;
let fostersOnboardedCount = 0;

function updateAdoptionCounts() {
    // Increment adoption applications
    adoptionApplicationsCount++;

    // Increment dogs adopted every 2nd adoption application
    if (adoptionApplicationsCount % 2 === 0) {
        dogsAdoptedCount++;
    }

    // Increment fosters onboarded every 5th adoption application
    if (adoptionApplicationsCount % 5 === 0) {
        fostersOnboardedCount++;
    }

    // Update the UI with new counts
    document.getElementById('adoption-applications').innerText = `Adoption Applications: ${adoptionApplicationsCount}`;
    document.getElementById('dogs-adopted').innerText = `Dogs Adopted: ${dogsAdoptedCount}`;
    document.getElementById('fosters-onboarded').innerText = `Fosters Onboarded: ${fostersOnboardedCount}`;
}
