# Portfolio Website

A modern portfolio website built with FastAPI backend and Vue.js frontend.

## Structure

- `backend/` - FastAPI Python backend
- `frontend/` - Vue.js TypeScript frontend

## Getting Started

### Backend

1. Navigate to the backend directory:
   ```bash
   cd backend
   ```

2. Install dependencies:
   ```bash
   pip install -r requirements.txt
   ```

3. Run the backend server:
   ```bash
   python main.py
   ```

The API will be available at `http://localhost:8000`

### Frontend

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Run the development server:
   ```bash
   npm run dev
   ```

The frontend will be available at `http://localhost:5173`

## Features

- Home page with project showcase
- Projects gallery with GitHub links
- Work experience timeline
- Skills visualization
- Contact form
- Responsive design
- TypeScript support

## API Endpoints

- `GET /api/projects` - Get all projects
- `GET /api/projects/{id}` - Get specific project
- `GET /api/experiences` - Get work experience
- `GET /api/skills` - Get skills

## Technologies Used

### Backend
- FastAPI
- Python
- Pydantic
- Uvicorn

### Frontend
- Vue.js 3
- TypeScript
- Vue Router
- Pinia (if needed)
- Axios
- Vite
