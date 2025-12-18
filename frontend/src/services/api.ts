import axios from 'axios'

const api = axios.create({
  baseURL: 'http://localhost:8000',
})

export interface Project {
  id: number
  title: string
  description: string
  technologies: string[]
  github_url?: string
  live_url?: string
}

export interface Experience {
  id: number
  title: string
  company: string
  period: string
  description: string
}

export interface Skill {
  id: number
  name: string
  category: string
  level: string
}

export const portfolioApi = {
  getProjects: () => api.get<Project[]>('/api/projects'),
  getProject: (id: number) => api.get<Project>(`/api/projects/${id}`),
  getExperiences: () => api.get<Experience[]>('/api/experiences'),
  getSkills: () => api.get<Skill[]>('/api/skills'),
}