<script setup lang="ts">
import { computed, ref } from 'vue'
import skillsData from '@/data/skills.json'

const skills = ref(skillsData)
const activeCategory = ref<string | null>(null)

function repoName(url: string): string {
  return url.substring(url.lastIndexOf('/') + 1)
}

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

function dotCount(proficiency: number): number {
  return Math.round(proficiency / 20)
}
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
          <div class="skills-grid">
            <div
              v-for="skill in catSkills"
              :key="skill.id + skill.name"
              class="skill-card"
            >
              <div class="skill-card__head">
                <span class="skill-card__name">{{ skill.name }}</span>
                <div class="skill-dots">
                  <span
                    v-for="i in 5"
                    :key="i"
                    class="dot"
                    :class="{ 'dot--filled': i <= dotCount(skill.proficiency) }"
                  ></span>
                </div>
              </div>
              <div
                v-if="skill.githubUrls.length"
                class="skill-card__projects"
              >
                <a
                  v-for="url in skill.githubUrls"
                  :key="url"
                  :href="url"
                  target="_blank"
                  rel="noopener"
                  class="skill-project-link"
                >
                  {{ repoName(url) }}
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div v-else-if="filtered.length" class="skills-grid">
        <div
          v-for="skill in filtered"
          :key="skill.id + skill.name"
          class="skill-card"
        >
          <div class="skill-card__head">
            <span class="skill-card__name">{{ skill.name }}</span>
            <div class="skill-dots">
              <span
                v-for="i in 5"
                :key="i"
                class="dot"
                :class="{ 'dot--filled': i <= dotCount(skill.proficiency) }"
              ></span>
            </div>
          </div>
          <div
            v-if="skill.githubUrls.length"
            class="skill-card__projects"
          >
            <a
              v-for="url in skill.githubUrls"
              :key="url"
              :href="url"
              target="_blank"
              rel="noopener"
              class="skill-project-link"
            >
              {{ repoName(url) }}
            </a>
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

.skills-categories {
  display: flex;
  flex-direction: column;
  gap: 2rem;
}

.category__title {
  color: var(--accent-light);
  font-size: 1.1rem;
  font-weight: 600;
  margin-bottom: 0.75rem;
  letter-spacing: 1px;
  border-bottom: 1px solid var(--border);
  padding-bottom: 0.5rem;
}

.skills-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(240px, 1fr));
  gap: 0.75rem;
}

.skill-card {
  background: var(--bg-card);
  border: 1px solid var(--border);
  border-radius: 8px;
  padding: 0.9rem 1rem;
  transition: all 0.2s;
}

.skill-card:hover {
  border-color: var(--accent);
  transform: translateY(-1px);
}

.skill-card__head {
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 0.5rem;
}

.skill-card__name {
  color: var(--text-heading);
  font-size: 0.9rem;
  font-weight: 600;
}

.skill-dots {
  display: flex;
  gap: 3px;
}

.dot {
  width: 8px;
  height: 8px;
  border-radius: 50%;
  background: var(--border);
  transition: background 0.2s;
}

.dot--filled {
  background: var(--accent);
}

.skill-card__projects {
  display: flex;
  flex-wrap: wrap;
  gap: 0.35rem;
  margin-top: 0.6rem;
  padding-top: 0.5rem;
  border-top: 1px solid var(--border);
}

.skill-project-link {
  font-size: 0.75rem;
  padding: 0.15rem 0.5rem;
  border-radius: 3px;
  background: rgba(168, 85, 247, 0.08);
  color: var(--accent);
  transition: all 0.2s;
}

.skill-project-link:hover {
  background: var(--accent);
  color: var(--btn-text);
  text-decoration: none;
}

.empty {
  color: var(--text-dim);
  font-style: italic;
}
</style>
