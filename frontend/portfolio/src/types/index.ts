export interface AboutMe {
  id: number
  name: string
  bio: string
  title: string
  email: string
  phone: string
  location: string
  githubUrl: string
  linkedinUrl: string
  websiteUrl: string
  profileImageUrl: string
}

export interface Skill {
  id: number
  name: string
  category: string
  iconUrl: string
  proficiency: number
}

export interface Project {
  id: number
  title: string
  description: string
  imageUrl: string
  projectUrl: string
  githubUrl: string
  technologies: string
}

export interface HomeInfo {
  message: string
  tagline: string
}
