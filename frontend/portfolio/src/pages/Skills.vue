<script setup lang="ts">
import { computed, ref } from 'vue'
import skillsData from '@/data/skills.json'

const skills = ref(skillsData)
const activeCategory = ref<string | null>(null)

const categories = computed(() => {
  const set = new Set(skills.value.map((s) => s.category))
  return Array.from(set)
})

const filtered = computed(() => {
  if (!activeCategory.value) return skills.value
  return skills.value.filter((s) => s.category === activeCategory.value)
})
</script>

<template>
  <div class="page">
    <div class="container">
      <h1 class="page__title">Skills</h1>

      <div v-if="categories.length" class="tabs">
        <button
          class="tab"
          :class="{ 'tab--active': activeCategory === null }"
          @click="activeCategory = null"
        >
          All
        </button>
        <button
          v-for="cat in categories"
          :key="cat"
          class="tab"
          :class="{ 'tab--active': activeCategory === cat }"
          @click="activeCategory = cat"
        >
          {{ cat }}
        </button>
      </div>

      <div v-if="filtered.length" class="skills-grid">
        <div v-for="skill in filtered" :key="skill.id" class="skill-card">
          <div class="skill__info">
            <span class="skill__name">{{ skill.name }}</span>
            <span class="skill__pct">{{ skill.proficiency }}%</span>
          </div>
          <div class="skill__bar">
            <div
              class="skill__fill"
              :style="{ width: skill.proficiency + '%' }"
            ></div>
          </div>
        </div>
      </div>

      <p v-else class="empty">No skills to display.</p>
    </div>
  </div>
</template>

<style scoped>
.page {
  max-width: 960px;
  margin: 0 auto;
}

.page__title {
  color: var(--accent-light);
  font-size: 2rem;
  font-weight: 700;
  letter-spacing: 2px;
  margin-bottom: 1.5rem;
}

.tabs {
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
  margin-bottom: 1.5rem;
}

.tab {
  padding: 0.4rem 1rem;
  border: 1px solid var(--border);
  border-radius: 4px;
  background: var(--bg-nav);
  color: var(--text);
  cursor: pointer;
  font-size: 0.85rem;
  font-weight: 500;
  transition: all 0.2s;
}

.tab:hover {
  border-color: var(--accent);
  color: var(--accent);
}

.tab--active {
  background: var(--accent);
  color: var(--btn-text);
  border-color: var(--accent);
}

.tab--active:hover {
  background: var(--accent-hover);
  border-color: var(--accent-hover);
  color: var(--btn-text);
}

.skills-grid {
  display: grid;
  gap: 1rem;
}

.skill-card {
  background: var(--bg-card);
  border: 1px solid var(--border);
  border-radius: 8px;
  padding: 1.25rem;
  transition: all 0.2s;
}

.skill-card:hover {
  border-color: var(--accent);
}

.skill__info {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 0.75rem;
}

.skill__name {
  color: var(--text-heading);
  font-size: 0.95rem;
  font-weight: 600;
}

.skill__pct {
  color: var(--text-muted);
  font-size: 0.85rem;
  font-weight: 500;
}

.skill__bar {
  height: 8px;
  background: var(--bg-nav);
  border-radius: 4px;
  overflow: hidden;
}

.skill__fill {
  height: 100%;
  background: linear-gradient(90deg, var(--accent), #e879f9);
  border-radius: 4px;
  transition: width 0.6s ease;
}

.empty {
  color: var(--text-dim);
  font-style: italic;
}
</style>
