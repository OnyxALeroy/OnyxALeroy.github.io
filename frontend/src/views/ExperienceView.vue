<template>
  <div class="experience">
    <h1>Work Experience</h1>
    <div class="experience-timeline">
      <div v-for="exp in experiences" :key="exp.id" class="experience-item">
        <div class="experience-header">
          <h3>{{ exp.title }}</h3>
          <span class="company">{{ exp.company }}</span>
          <span class="period">{{ exp.period }}</span>
        </div>
        <p class="description">{{ exp.description }}</p>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { portfolioApi, type Experience } from '@/services/api'

const experiences = ref<Experience[]>([])

onMounted(async () => {
  try {
    const response = await portfolioApi.getExperiences()
    experiences.value = response.data
  } catch (error) {
    console.error('Error fetching experiences:', error)
  }
})
</script>

<style scoped>
.experience {
  max-width: 800px;
  margin: 0 auto;
  padding: 2rem;
}

.experience h1 {
  text-align: center;
  margin-bottom: 3rem;
  color: #2c3e50;
}

.experience-timeline {
  position: relative;
}

.experience-timeline::before {
  content: '';
  position: absolute;
  left: 20px;
  top: 0;
  bottom: 0;
  width: 2px;
  background: #3498db;
}

.experience-item {
  position: relative;
  padding-left: 60px;
  margin-bottom: 3rem;
}

.experience-item::before {
  content: '';
  position: absolute;
  left: 12px;
  top: 5px;
  width: 18px;
  height: 18px;
  border-radius: 50%;
  background: #3498db;
  border: 3px solid white;
  box-shadow: 0 0 0 3px #3498db;
}

.experience-header {
  display: flex;
  flex-direction: column;
  margin-bottom: 1rem;
}

.experience-header h3 {
  color: #2c3e50;
  margin-bottom: 0.5rem;
  font-size: 1.5rem;
}

.company {
  color: #3498db;
  font-weight: bold;
  margin-bottom: 0.25rem;
}

.period {
  color: #7f8c8d;
  font-size: 0.9rem;
}

.description {
  color: #555;
  line-height: 1.6;
}
</style>