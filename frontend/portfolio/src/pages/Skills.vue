<script setup lang="ts">
import { computed, ref } from 'vue'
import skillsData from '@/data/skills.json'

const skills = ref(skillsData)
const activeCategory = ref<string | null>(null)

const categories = computed(() => {
  const set = new Set(skills.value.map((s) => s.category))
  return Array.from(set)
})

const grouped = computed(() => {
  const all = skills.value.slice().sort((a, b) => b.proficiency - a.proficiency)
  const map = new Map<string, typeof all>()
  for (const skill of all) {
    const cat = skill.category
    if (!map.has(cat)) map.set(cat, [])
    map.get(cat)!.push(skill)
  }
  return map
})

const filtered = computed(() => {
  if (!activeCategory.value) return skills.value.slice().sort((a, b) => b.proficiency - a.proficiency)
  return skills.value
    .filter((s) => s.category === activeCategory.value)
    .sort((a, b) => b.proficiency - a.proficiency)
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

      <div v-if="activeCategory === null" class="skills-categories">
        <div
          v-for="[cat, catSkills] in grouped"
          :key="cat"
          class="category-group"
        >
          <h2 class="category__title">{{ cat }}</h2>
          <div class="skills-chips">
            <span
              v-for="skill in catSkills"
              :key="skill.id + skill.name"
              class="chip"
              :style="{ '--rank': (catSkills.indexOf(skill) + 1) }"
            >
              {{ skill.name }}
            </span>
          </div>
        </div>
      </div>

      <div v-else-if="filtered.length" class="skills-chips">
        <span
          v-for="skill in filtered"
          :key="skill.id + skill.name"
          class="chip"
          :style="{ '--rank': (filtered.indexOf(skill) + 1) }"
        >
          {{ skill.name }}
        </span>
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

.skills-categories {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.category__title {
  color: var(--accent-light);
  font-size: 1rem;
  font-weight: 600;
  margin-bottom: 0.75rem;
  letter-spacing: 1px;
}

.skills-chips {
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
}

.chip {
  background: var(--bg-card);
  border: 1px solid var(--border);
  border-radius: 6px;
  padding: 0.5rem 1rem;
  font-size: 0.9rem;
  font-weight: 500;
  color: var(--text-heading);
  transition: all 0.2s;
}

.chip:hover {
  border-color: var(--accent);
  color: var(--accent);
  transform: translateY(-1px);
}

.empty {
  color: var(--text-dim);
  font-style: italic;
}
</style>
