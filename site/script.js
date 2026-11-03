const button = document.getElementById('reveal');
const letter = document.getElementById('secret');

button.addEventListener('click', () => {
  const opening = letter.hidden;

  letter.hidden = !opening;
  button.setAttribute('aria-expanded', String(opening));
  button.textContent = opening ? 'Close letter 💕' : 'Read my letter 💕';
});