<template>
  <div class="projects">
    <h1>My Projects</h1>
    <div class="projects-grid">
      <div v-for="project in projects" :key="project.id" class="project-card">
        <h3>{{ project.title }}</h3>
        <p>{{ project.description }}</p>
        <div class="tech-stack">
          <span v-for="tech in project.technologies" :key="tech" class="tech-tag">
            {{ tech }}
          </span>
        </div>
        <div class="project-links">
          <a v-if="project.github_url" :href="project.github_url" target="_blank" class="link-btn github">
            GitHub
          </a>
          <a v-if="project.live_url" :href="project.live_url" target="_blank" class="link-btn live">
            Live Demo
          </a>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { portfolioApi, type Project } from '@/services/api'

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
.projects {
  max-width: 1200px;
  margin: 0 auto;
  padding: 2rem;
}

.projects h1 {
  text-align: center;
  margin-bottom: 3rem;
  color: #2c3e50;
}

.projects-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
  gap: 2rem;
}

.project-card {
  background: white;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease;
}

.project-card:hover {
  transform: translateY(-5px);
}

.project-card h3 {
  color: #2c3e50;
  margin-bottom: 1rem;
  font-size: 1.5rem;
}

.project-card p {
  color: #7f8c8d;
  margin-bottom: 1.5rem;
  line-height: 1.6;
}

.tech-stack {
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
  margin-bottom: 1.5rem;
}

.tech-tag {
  background: #3498db;
  color: white;
  padding: 0.25rem 0.5rem;
  border-radius: 4px;
  font-size: 0.875rem;
}

.project-links {
  display: flex;
  gap: 1rem;
}

.link-btn {
  padding: 0.5rem 1rem;
  border-radius: 4px;
  text-decoration: none;
  font-weight: bold;
  transition: background-color 0.3s ease;
}

.link-btn.github {
  background: #333;
  color: white;
}

.link-btn.github:hover {
  background: #555;
}

.link-btn.live {
  background: #27ae60;
  color: white;
}

.link-btn.live:hover {
  background: #2ecc71;
}
</style>