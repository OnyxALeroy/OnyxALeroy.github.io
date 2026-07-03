# Portfolio Website

Static portfolio website built with Vue 3 + TypeScript, auto-deployed to GitHub Pages via GitHub Actions.

## Structure

- `frontend/portfolio/` — Vue 3 TypeScript SPA
- `.github/workflows/deploy.yml` — auto-deploy on push to `main`

## Getting Started

```bash
cd frontend/portfolio
npm install
npm run dev
```

## Deploy

Push to `main` — GitHub Actions builds and deploys to GitHub Pages automatically.

## Data

Edit `frontend/portfolio/src/data/*.json` to update your portfolio content.
