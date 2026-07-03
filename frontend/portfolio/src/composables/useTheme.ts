import { ref } from 'vue'

const isDark = ref(true)

function apply() {
  document.documentElement.classList.toggle('light-mode', !isDark.value)
}

function init() {
  const stored = localStorage.getItem('theme')
  isDark.value = stored !== 'light'
  apply()
}

function toggle() {
  isDark.value = !isDark.value
  localStorage.setItem('theme', isDark.value ? 'dark' : 'light')
  apply()
}

export function useTheme() {
  return { isDark, init, toggle }
}
