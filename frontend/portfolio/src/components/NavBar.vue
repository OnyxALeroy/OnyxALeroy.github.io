<script setup lang="ts">
import { useRoute } from 'vue-router'
import { useTheme } from '@/composables/useTheme'

const route = useRoute()
const { isDark, toggle } = useTheme()

const links = [
  { name: 'home', path: '/', label: 'Home' },
  { name: 'about', path: '/about', label: 'About' },
  { name: 'skills', path: '/skills', label: 'Skills' },
  { name: 'projects', path: '/projects', label: 'Projects' },
]
</script>

<template>
  <nav class="navbar">
    <div class="navbar__inner">
      <router-link to="/" class="navbar__brand">Portfolio</router-link>
      <div class="navbar__right">
        <div class="navbar__links">
          <router-link
            v-for="link in links"
            :key="link.name"
            :to="link.path"
            class="navbar__link"
            :class="{ 'navbar__link--active': route.name === link.name }"
          >
            {{ link.label }}
          </router-link>
        </div>
        <button class="theme-btn" @click="toggle" :title="isDark ? 'Switch to light mode' : 'Switch to dark mode'">
          {{ isDark ? '☀' : '☾' }}
        </button>
      </div>
    </div>
  </nav>
</template>

<style scoped>
.navbar {
  background: var(--bg-nav);
  border-bottom: 1px solid var(--border);
  position: sticky;
  top: 0;
  z-index: 100;
}

.navbar__inner {
  max-width: 960px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 1.5rem;
  height: 60px;
}

.navbar__brand {
  color: var(--accent-light);
  font-size: 1.2rem;
  font-weight: 800;
  letter-spacing: 2px;
  text-transform: uppercase;
}

.navbar__brand:hover {
  color: var(--accent);
  text-decoration: none;
}

.navbar__right {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.navbar__links {
  display: flex;
  gap: 0.25rem;
}

.navbar__link {
  color: var(--text);
  padding: 0.5rem 0.75rem;
  border-radius: 4px;
  font-size: 0.9rem;
  font-weight: 500;
  transition: all 0.15s;
}

.navbar__link:hover {
  background: var(--bg-card);
  color: var(--accent-light);
  text-decoration: none;
}

.navbar__link--active {
  background: var(--bg-card);
  color: var(--accent-light);
}

.theme-btn {
  background: var(--bg-card);
  border: 1px solid var(--accent);
  border-radius: 4px;
  padding: 0.35rem 0.6rem;
  font-size: 1.1rem;
  color: var(--accent);
  cursor: pointer;
  transition: all 0.2s;
  line-height: 1;
}

.theme-btn:hover {
  background: var(--accent);
  color: var(--btn-text);
}

@media (max-width: 768px) {
  .navbar__inner {
    flex-direction: column;
    height: auto;
    gap: 0.5rem;
    padding: 0.75rem 1rem;
  }

  .navbar__right {
    width: 100%;
    justify-content: space-between;
  }

  .navbar__links {
    flex-wrap: wrap;
  }
}
</style>
