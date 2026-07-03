<script setup lang="ts">
import { onMounted } from 'vue'
import { useTheme } from '@/composables/useTheme'
import NavBar from '@/components/NavBar.vue'

const { init } = useTheme()

onMounted(() => {
  init()
})
</script>

<template>
  <NavBar />
  <main class="main">
    <router-view />
  </main>
</template>

<style>
*,
*::before,
*::after {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

:root {
  --bg: #02050a;
  --bg-card: #08121f;
  --bg-nav: #050b16;
  --border: #1b2a3a;
  --accent: #a855f7;
  --accent-hover: #9333ea;
  --accent-light: #c084fc;
  --text: #c9e5ff;
  --text-heading: #e2e8f0;
  --text-muted: #94a3b8;
  --text-dim: #64748b;
  --text-bio: #cbd5e1;
  --btn-text: #fff;
}

:root.light-mode {
  --bg: #f8f9fa;
  --bg-card: #ffffff;
  --bg-nav: #ffffff;
  --border: #e2e8f0;
  --accent: #7c3aed;
  --accent-hover: #6d28d9;
  --accent-light: #8b5cf6;
  --text: #334155;
  --text-heading: #0f172a;
  --text-muted: #64748b;
  --text-dim: #94a3b8;
  --text-bio: #475569;
  --btn-text: #fff;
}

body {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, sans-serif;
  background: var(--bg);
  color: var(--text);
  line-height: 1.6;
}

a {
  color: var(--accent);
  text-decoration: none;
}

a:hover {
  color: var(--accent-hover);
}
</style>

<style scoped>
.main {
  min-height: calc(100vh - 60px);
  padding: 2rem;
}
</style>
