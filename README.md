# Birthday website ❤️

A responsive birthday website with a photo gallery and a revealable love letter.

## No packages required

The HTML/CSS/JavaScript site works in a modern browser with no installation or build step.

The optional Java server requires only JDK 17+ and uses the JDK built-in HTTP server (no Maven or Spring Boot dependencies).

## Preview it on your computer

Open site/index.html in your browser.

Or, from the birthday-website folder, run:

```bash
java java/Main.java
```

Then open http://localhost:8080.

Keep the terminal running while previewing.

## Customize

Edit site/index.html to change the text.

Replace each `<div class="photo">...</div>` with an image, for example:

```html
<img class="photo" src="images/first-date.jpg" alt="Our first date">
```

Create site/images and place your own image files there.

Add these rules to the bottom of site/style.css:

```css
img.photo {
  width: 100%;
  object-fit: cover;
  display: block;
}
```

## Share with a public link (free)

1. Create a public GitHub repository, for example birthday-surprise.
2. Upload the contents of the site folder to the repository root (index.html, style.css, script.js, and any images folder). Do not upload java for this hosting option.
3. In the repository open Settings → Pages, then select Deploy from a branch, choose main and / (root), and save.
4. After deployment GitHub Pages provides a link such as https://YOUR-USERNAME.github.io/birthday-surprise/. Send that link to your boyfriend.

Important: GitHub Pages hosts static HTML/CSS/JavaScript, not the Java server. A public repository makes its contents visible to others, so avoid private photos or messages if you don't want them public. The link works when your computer is off.
