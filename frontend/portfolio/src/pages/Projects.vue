<script setup lang="ts">
import { ref } from 'vue'
import { marked } from 'marked'
import projectsData from '@/data/projects.json'

const projects = ref(projectsData)

function techList(technologies: string): string[] {
  return technologies.split(', ').filter(Boolean)
}

function renderMd(md: string): string {
  return marked.parse(md) as string
}
</script>

<template>
  <div class="page">
    <div class="container">
      <h1 class="page__title">Projects</h1>

      <div v-if="projects.length" class="projects-grid">
        <div v-for="project in projects" :key="project.id" class="project-card">
          <img
            v-if="project.imageUrl"
            :src="project.imageUrl"
            :alt="project.title"
            class="project__image"
          />
          <div class="project__body">
            <h2 class="project__title">{{ project.title }}</h2>
            <p class="project__desc">{{ project.description }}</p>
            <div
              v-if="project.details"
              class="project__details"
              v-html="renderMd(project.details)"
            ></div>
            <div v-if="project.technologies" class="project__tags">
              <span
                v-for="tech in techList(project.technologies)"
                :key="tech"
                class="tag"
              >
                {{ tech }}
              </span>
            </div>
          </div>
          <div class="project__footer">
            <a
              v-if="project.projectUrl"
              :href="project.projectUrl"
              target="_blank"
              rel="noopener"
              class="btn btn--primary"
            >
              Live Demo
            </a>
            <a
              v-if="project.githubUrl"
              :href="project.githubUrl"
              target="_blank"
              rel="noopener"
              class="btn btn--outline"
            >
              Source
            </a>
          </div>
        </div>
      </div>

      <p v-else class="empty">No projects to display.</p>
    </div>
  </div>
</template>

<style scoped>
.page {
  max-width: 1100px;
  margin: 0 auto;
}

.page__title {
  color: var(--accent-light);
  font-size: 2rem;
  font-weight: 700;
  letter-spacing: 2px;
  margin-bottom: 1.5rem;
}

.projects-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 1.5rem;
}

.project-card {
  background: var(--bg-card);
  border: 1px solid var(--border);
  border-radius: 8px;
  padding: 1.5rem;
  display: flex;
  flex-direction: column;
  gap: 1rem;
  transition: all 0.2s;
}

.project__image {
  width: 100%;
  height: 200px;
  object-fit: cover;
  border-radius: 6px;
  margin-bottom: 0.5rem;
}

.project-card:hover {
  border-color: var(--accent);
  transform: translateY(-2px);
}

.project__title {
  color: var(--text-heading);
  font-size: 1.2rem;
  margin-bottom: 0.5rem;
}

.project__desc {
  color: var(--text-bio);
  font-size: 0.9rem;
  line-height: 1.6;
}

.project__details {
  color: var(--text-bio);
  font-size: 0.9rem;
  line-height: 1.7;
}

.project__details :deep(h1),
.project__details :deep(h2),
.project__details :deep(h3),
.project__details :deep(h4) {
  color: var(--text-heading);
  margin: 1rem 0 0.5rem;
  font-size: 1rem;
}

.project__details :deep(h2) {
  font-size: 1.05rem;
  border-bottom: 1px solid var(--border);
  padding-bottom: 0.3rem;
}

.project__details :deep(ul),
.project__details :deep(ol) {
  padding-left: 1.25rem;
  margin: 0.4rem 0;
}

.project__details :deep(li) {
  margin-bottom: 0.25rem;
}

.project__details :deep(strong) {
  color: var(--text-heading);
}

.project__details :deep(code) {
  background: rgba(168, 85, 247, 0.08);
  padding: 0.15rem 0.4rem;
  border-radius: 3px;
  font-size: 0.85em;
}

.project__details :deep(p) {
  margin: 0.4rem 0;
}

.project__tags {
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
  margin-top: 0.75rem;
}

.tag {
  background: rgba(168, 85, 247, 0.1);
  color: var(--accent);
  font-size: 0.8rem;
  font-weight: 500;
  padding: 0.25rem 0.65rem;
  border-radius: 4px;
}

.project__footer {
  display: flex;
  gap: 0.75rem;
  padding-top: 1rem;
  border-top: 1px solid var(--border);
}

.btn {
  padding: 0.5rem 1.25rem;
  border-radius: 4px;
  font-weight: 600;
  font-size: 0.85rem;
  transition: all 0.2s;
}

.btn:hover {
  text-decoration: none;
}

.btn--primary {
  background: var(--accent);
  color: var(--btn-text);
}

.btn--primary:hover {
  background: var(--accent-hover);
}

.btn--outline {
  border: 1px solid var(--accent);
  color: var(--accent);
}

.btn--outline:hover {
  background: var(--accent);
  color: var(--btn-text);
}

.empty {
  color: var(--text-dim);
  font-style: italic;
}

@media (max-width: 768px) {
  .projects-grid {
    grid-template-columns: 1fr;
  }

  .project__footer {
    flex-direction: column;
  }

  .project__footer .btn {
    text-align: center;
  }
}
</style>
