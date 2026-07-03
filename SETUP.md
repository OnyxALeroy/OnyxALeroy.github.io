# GitHub Pages Setup Guide

## Prerequisites

1. A GitHub account
2. Git configured locally (`git config --global user.name` and `git config --global user.email`)

---

## Step 0: Set your personal data

Before deploying, replace the placeholder data with your own.

### About Me
Edit `frontend/portfolio/src/data/about.json`:
- `name` — your full name
- `title` — e.g. "Full-Stack Developer"
- `bio` — short description about yourself
- `email`, `phone`, `location` — contact info
- `githubUrl`, `linkedinUrl`, `websiteUrl` — social links

### Home tagline
Edit `frontend/portfolio/src/data/home.json`:
- `message` — main heading (e.g. "Welcome to my portfolio")
- `tagline` — subtitle (e.g. "Full-stack developer & problem solver")

### Skills
Edit `frontend/portfolio/src/data/skills.json`:
- `name` — technology name
- `category` — group name (e.g. "Frontend", "Backend", "Database", "DevOps")
- `proficiency` — number 0–100

### Projects
Edit `frontend/portfolio/src/data/projects.json`:
- `title` — project name
- `description` — what it does
- `projectUrl` — live demo link (or empty string)
- `githubUrl` — source code link (or empty string)
- `technologies` — comma-separated, e.g. `"Vue.js, Spring Boot, Docker"`

### Profile image
The About Me page shows your initial as an avatar by default. To add a real photo:
1. Place an image file in `frontend/portfolio/public/` (e.g. `photo.jpg`)
2. Set `"profileImageUrl": "/photo.jpg"` in `about.json`

### Project images
1. Place images in `frontend/portfolio/public/images/`
2. Set `"imageUrl": "/images/my-project.jpg"` in `projects.json`

### CV / Resume
Place your CV PDF at `frontend/portfolio/public/cv.pdf`. The "Download CV" button on the home page will link to it.

---

## Step 1: Create the GitHub repository

1. Go to https://github.com/new
2. In the **Repository name** field, enter: `<your-username>.github.io`
   - Replace `<your-username>` with your actual GitHub username (e.g., `johndoe.github.io`)
   - The name **must** be exactly `<username>.github.io`
3. Leave it **Public**
4. Do **not** check "Add a README" or any other options
5. Click **Create repository**

---

## Step 2: Push this project to GitHub

Open a terminal in this project's root directory and run:

```bash
git remote add origin https://github.com/<your-username>/<your-username>.github.io.git
git branch -M main
git push -u origin main
```

Replace `<your-username>` with your GitHub username in the URL above.

---

## Step 3: Enable GitHub Pages

1. Go to https://github.com/<your-username>/<your-username>.github.io
2. Click the **Settings** tab
3. In the left sidebar, click **Pages**
4. Under **Branch**, select `gh-pages` and `/ (root)`
5. Click **Save**

---

## Step 4: Wait for deployment

1. Go to the **Actions** tab of your repo
2. You should see a workflow named "Deploy to GitHub Pages" running
3. Wait for it to finish (green checkmark)
4. Visit `https://<your-username>.github.io` — your site is live!

---

## Updating your portfolio later

1. Edit the files in `frontend/portfolio/src/data/` (e.g., `about.json`, `projects.json`)
2. Edit `frontend/portfolio/src/data/projects.json` to add/change projects
3. Commit and push to `main`:

```bash
git add .
git commit -m "Update portfolio content"
git push
```

4. The GitHub Actions workflow will auto-deploy your changes
5. Site updates in ~1 minute

---

## Previewing locally (without Docker)

```bash
cd frontend/portfolio
npm install
npm run dev
```

This starts a dev server at `http://localhost:5173`.

---

## Previewing with the full backend (Docker)

```bash
docker compose up --build -d
```

Then visit `http://localhost`. The backend serves data, and you can edit `backend/src/main/resources/data.sql` for database changes.
