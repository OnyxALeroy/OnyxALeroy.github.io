from typing import List, Optional

from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel

app = FastAPI(title="Portfolio API")

# Enable CORS for frontend
app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:3000", "http://localhost:5173"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)


# Models
class Project(BaseModel):
    id: int
    title: str
    description: str
    technologies: List[str]
    github_url: Optional[str] = None
    live_url: Optional[str] = None


class Experience(BaseModel):
    id: int
    title: str
    company: str
    period: str
    description: str


class Skill(BaseModel):
    id: int
    name: str
    category: str
    level: str


# Sample data
projects = [
    Project(
        id=1,
        title="E-commerce Platform",
        description="Full-stack e-commerce solution with payment integration",
        technologies=["React", "Node.js", "MongoDB", "Stripe"],
        github_url="https://github.com/example/ecommerce",
        live_url="https://example-ecommerce.com",
    ),
    Project(
        id=2,
        title="Task Management App",
        description="Collaborative task management tool with real-time updates",
        technologies=["Vue.js", "Python", "PostgreSQL", "WebSocket"],
        github_url="https://github.com/example/taskmanager",
    ),
]

experiences = [
    Experience(
        id=1,
        title="Senior Full Stack Developer",
        company="Tech Company",
        period="2022 - Present",
        description="Leading development of enterprise applications",
    ),
    Experience(
        id=2,
        title="Frontend Developer",
        company="Startup XYZ",
        period="2020 - 2022",
        description="Built responsive web applications using modern frameworks",
    ),
]

skills = [
    Skill(id=1, name="JavaScript", category="Frontend", level="Expert"),
    Skill(id=2, name="Python", category="Backend", level="Advanced"),
    Skill(id=3, name="Vue.js", category="Frontend", level="Advanced"),
    Skill(id=4, name="React", category="Frontend", level="Advanced"),
    Skill(id=5, name="FastAPI", category="Backend", level="Intermediate"),
    Skill(id=6, name="PostgreSQL", category="Database", level="Advanced"),
]


# Routes
@app.get("/")
async def root():
    return {"message": "Portfolio API"}


@app.get("/api/projects", response_model=List[Project])
async def get_projects():
    return projects


@app.get("/api/projects/{project_id}", response_model=Project)
async def get_project(project_id: int):
    project = next((p for p in projects if p.id == project_id), None)
    if not project:
        from fastapi import HTTPException

        raise HTTPException(status_code=404, detail="Project not found")
    return project


@app.get("/api/experiences", response_model=List[Experience])
async def get_experiences():
    return experiences


@app.get("/api/skills", response_model=List[Skill])
async def get_skills():
    return skills


if __name__ == "__main__":
    import uvicorn

    uvicorn.run(app, host="0.0.0.0", port=8000)
