<template>
  <div class="skills">
    <h1>Skills</h1>
    <div class="skills-container">
      <div v-for="category in skillCategories" :key="category.name" class="skill-category">
        <h2>{{ category.name }}</h2>
        <div class="skills-grid">
          <div v-for="skill in category.skills" :key="skill.id" class="skill-item">
            <div class="skill-info">
              <span class="skill-name">{{ skill.name }}</span>
              <span class="skill-level" :class="levelClass(skill.level)">{{ skill.level }}</span>
            </div>
            <div class="skill-bar">
              <div class="skill-progress" :class="levelClass(skill.level)" :style="{ width: levelWidth(skill.level) }"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted, computed } from 'vue'
import { portfolioApi, type Skill } from '@/services/api'

const skills = ref<Skill[]>([])

const skillCategories = computed(() => {
  const categories: { [key: string]: Skill[] } = {}
  skills.value.forEach(skill => {
    if (!categories[skill.category]) {
      categories[skill.category] = []
    }
    categories[skill.category].push(skill)
  })
  
  return Object.entries(categories).map(([name, skills]) => ({
    name,
    skills
  }))
})

const levelClass = (level: string) => {
  switch (level.toLowerCase()) {
    case 'expert':
      return 'expert'
    case 'advanced':
      return 'advanced'
    case 'intermediate':
      return 'intermediate'
    case 'beginner':
      return 'beginner'
    default:
      return 'intermediate'
  }
}

const levelWidth = (level: string) => {
  switch (level.toLowerCase()) {
    case 'expert':
      return '95%'
    case 'advanced':
      return '80%'
    case 'intermediate':
      return '60%'
    case 'beginner':
      return '40%'
    default:
      return '50%'
  }
}

onMounted(async () => {
  try {
    const response = await portfolioApi.getSkills()
    skills.value = response.data
  } catch (error) {
    console.error('Error fetching skills:', error)
  }
})
</script>

<style scoped>
.skills {
  max-width: 1000px;
  margin: 0 auto;
  padding: 2rem;
}

.skills h1 {
  text-align: center;
  margin-bottom: 3rem;
  color: #2c3e50;
}

.skill-category {
  margin-bottom: 3rem;
}

.skill-category h2 {
  color: #3498db;
  margin-bottom: 2rem;
  border-bottom: 2px solid #3498db;
  padding-bottom: 0.5rem;
}

.skills-grid {
  display: grid;
  gap: 1.5rem;
}

.skill-item {
  background: white;
  padding: 1.5rem;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.skill-info {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1rem;
}

.skill-name {
  font-weight: bold;
  color: #2c3e50;
}

.skill-level {
  font-size: 0.875rem;
  padding: 0.25rem 0.75rem;
  border-radius: 12px;
  font-weight: bold;
}

.skill-level.expert {
  background: #27ae60;
  color: white;
}

.skill-level.advanced {
  background: #3498db;
  color: white;
}

.skill-level.intermediate {
  background: #f39c12;
  color: white;
}

.skill-level.beginner {
  background: #95a5a6;
  color: white;
}

.skill-bar {
  height: 8px;
  background: #ecf0f1;
  border-radius: 4px;
  overflow: hidden;
}

.skill-progress {
  height: 100%;
  border-radius: 4px;
  transition: width 0.3s ease;
}

.skill-progress.expert {
  background: #27ae60;
}

.skill-progress.advanced {
  background: #3498db;
}

.skill-progress.intermediate {
  background: #f39c12;
}

.skill-progress.beginner {
  background: #95a5a6;
}
</style>