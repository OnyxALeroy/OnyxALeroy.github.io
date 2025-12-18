<template>
  <div class="home">
    <section class="hero">
      <h1>{{ name }}</h1>
      <p class="title">{{ title }}</p>
      <p class="intro">{{ introduction }}</p>
    </section>
    
    <section class="recent-projects">
      <h2>Recent Projects</h2>
      <div class="projects-grid">
        <div v-for="project in projects.slice(0, 3)" :key="project.id" class="project-card">
          <h3>{{ project.title }}</h3>
          <p>{{ project.description }}</p>
          <div class="tech-stack">
            <span v-for="tech in project.technologies" :key="tech" class="tech-tag">
              {{ tech }}
            </span>
          </div>
        </div>
      </div>
      <router-link to="/projects" class="view-all-btn">View All Projects</router-link>
    </section>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { portfolioApi, type Project } from '@/services/api'

const name = ref('John Doe')
const title = ref('Full Stack Developer')
const introduction = ref('Passionate about building modern web applications with cutting-edge technologies.')

const projects = ref<Project[]>([])

onMounted(async () => {
  try {
    const response = await portfolioApi.getProjects()
    projects.value = response.data
  } catch (error) {
    console.error('Error fetching projects:', error)
  }
})
</script>

<style scoped>
.home {
  max-width: 1200px;
  margin: 0 auto;
  padding: 2rem;
}

.hero {
  text-align: center;
  margin-bottom: 4rem;
}

.hero h1 {
  font-size: 3rem;
  margin-bottom: 0.5rem;
  color: #2c3e50;
}

.title {
  font-size: 1.5rem;
  color: #3498db;
  margin-bottom: 1rem;
}

.intro {
  font-size: 1.1rem;
  color: #7f8c8d;
  max-width: 600px;
  margin: 0 auto;
}

.recent-projects {
  margin-top: 3rem;
}

.recent-projects h2 {
  text-align: center;
  margin-bottom: 2rem;
  color: #2c3e50;
}

.projects-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 2rem;
  margin-bottom: 2rem;
}

.project-card {
  background: white;
  padding: 1.5rem;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease;
}

.project-card:hover {
  transform: translateY(-5px);
}

.project-card h3 {
  color: #2c3e50;
  margin-bottom: 0.5rem;
}

.project-card p {
  color: #7f8c8d;
  margin-bottom: 1rem;
}

.tech-stack {
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
}

.tech-tag {
  background: #3498db;
  color: white;
  padding: 0.25rem 0.5rem;
  border-radius: 4px;
  font-size: 0.875rem;
}

.view-all-btn {
  display: block;
  text-align: center;
  color: #3498db;
  text-decoration: none;
  font-weight: bold;
  margin-top: 2rem;
}

.view-all-btn:hover {
  text-decoration: underline;
}
</style>
