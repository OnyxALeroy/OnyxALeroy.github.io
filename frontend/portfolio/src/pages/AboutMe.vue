<script setup lang="ts">
import data from '@/data/about.json'

const profile = data[0] ?? null
</script>

<template>
  <div class="page">
    <div class="container">
      <h1 class="page__title">About Me</h1>

      <template v-if="profile">
        <div class="profile">
          <div class="profile__side">
            <div class="profile__avatar">{{ profile.name.charAt(0) }}</div>
            <h2 class="profile__name">{{ profile.name }}</h2>
            <p class="profile__title">{{ profile.title }}</p>

            <div v-if="profile.email || profile.phone || profile.location" class="profile__card">
              <h3 class="profile__card-title">Contact</h3>
              <div v-if="profile.email" class="profile__row">
                <svg class="profile__icon" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z"/></svg>
                <a :href="`mailto:${profile.email}`">{{ profile.email }}</a>
              </div>
              <div v-if="profile.phone" class="profile__row">
                <svg class="profile__icon" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M22 16.92v3a2 2 0 01-2.18 2 19.79 19.79 0 01-8.63-3.07 19.5 19.5 0 01-6-6 19.79 19.79 0 01-3.07-8.67A2 2 0 014.11 2h3a2 2 0 012 1.72 12.84 12.84 0 00.7 2.81 2 2 0 01-.45 2.11L8.09 9.91a16 16 0 006 6l1.27-1.27a2 2 0 012.11-.45 12.84 12.84 0 002.81.7A2 2 0 0122 16.92z"/></svg>
                <span>{{ profile.phone }}</span>
              </div>
              <div v-if="profile.location" class="profile__row">
                <svg class="profile__icon" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M21 10c0 7-9 13-9 13s-9-6-9-13a9 9 0 0118 0z"/><circle cx="12" cy="10" r="3"/></svg>
                <span>{{ profile.location }}</span>
              </div>
            </div>

            <div class="profile__card">
              <h3 class="profile__card-title">Links</h3>
              <a v-if="profile.githubUrl" :href="profile.githubUrl" target="_blank" rel="noopener" class="profile__row">
                <svg class="profile__icon" viewBox="0 0 24 24" fill="currentColor"><path d="M12 0C5.37 0 0 5.37 0 12c0 5.31 3.435 9.795 8.205 11.385.6.105.825-.255.825-.57 0-.285-.015-1.23-.015-2.235-3.015.555-3.795-.735-4.035-1.41-.135-.345-.72-1.41-1.23-1.695-.42-.225-1.02-.78-.015-.795.945-.015 1.62.87 1.845 1.23 1.08 1.815 2.805 1.305 3.495.99.105-.78.42-1.305.765-1.605-2.67-.3-5.46-1.335-5.46-5.925 0-1.305.465-2.385 1.23-3.225-.12-.3-.54-1.53.12-3.18 0 0 1.005-.315 3.3 1.23.96-.27 1.98-.405 3-.405s2.04.135 3 .405c2.295-1.56 3.3-1.23 3.3-1.23.66 1.65.24 2.88.12 3.18.765.84 1.23 1.905 1.23 3.225 0 4.605-2.805 5.625-5.475 5.925.435.375.81 1.095.81 2.22 0 1.605-.015 2.895-.015 3.3 0 .315.225.69.825.57A12.02 12.02 0 0024 12c0-6.63-5.37-12-12-12z"/></svg>
                <span>GitHub</span>
              </a>
              <a v-if="profile.linkedinUrl" :href="profile.linkedinUrl" target="_blank" rel="noopener" class="profile__row">
                <svg class="profile__icon" viewBox="0 0 24 24" fill="currentColor"><path d="M20.447 20.452h-3.554v-5.569c0-1.328-.027-3.037-1.852-3.037-1.853 0-2.136 1.445-2.136 2.939v5.667H9.351V9h3.414v1.561h.046c.477-.9 1.637-1.85 3.37-1.85 3.601 0 4.267 2.37 4.267 5.455v6.286zM5.337 7.433a2.062 2.062 0 01-2.063-2.065 2.064 2.064 0 112.063 2.065zm1.782 13.019H3.555V9h3.564v11.452zM22.225 0H1.771C.792 0 0 .774 0 1.729v20.542C0 23.227.792 24 1.771 24h20.451C23.2 24 24 23.227 24 22.271V1.729C24 .774 23.2 0 22.222 0h.003z"/></svg>
                <span>LinkedIn</span>
              </a>
              <a v-if="profile.websiteUrl" :href="profile.websiteUrl" target="_blank" rel="noopener" class="profile__row">
                <svg class="profile__icon" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><circle cx="12" cy="12" r="10"/><line x1="2" y1="12" x2="22" y2="12"/><path d="M12 2a15.3 15.3 0 014 10 15.3 15.3 0 01-4 10 15.3 15.3 0 01-4-10 15.3 15.3 0 014-10z"/></svg>
                <span>Website</span>
              </a>
            </div>
          </div>

          <div class="profile__main">
            <p class="profile__bio">{{ profile.bio }}</p>
          </div>
        </div>
      </template>

      <p v-else class="empty">Could not load profile information.</p>
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
  margin-bottom: 2rem;
}

.profile {
  display: grid;
  grid-template-columns: 280px 1fr;
  gap: 2.5rem;
  align-items: start;
}

.profile__side {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

.profile__avatar {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  background: linear-gradient(135deg, var(--accent), #e879f9);
  color: #fff;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 2.5rem;
  font-weight: 700;
  margin-bottom: 1rem;
  flex-shrink: 0;
}

.profile__name {
  color: var(--text-heading);
  font-size: 1.5rem;
  margin-bottom: 0.25rem;
}

.profile__title {
  color: var(--text-muted);
  font-size: 0.95rem;
  margin-bottom: 1.5rem;
}

.profile__card {
  width: 100%;
  background: var(--bg-card);
  border: 1px solid var(--border);
  border-radius: 8px;
  padding: 1rem;
  margin-bottom: 1rem;
  text-align: left;
}

.profile__card-title {
  color: var(--text-muted);
  font-size: 0.7rem;
  font-weight: 600;
  text-transform: uppercase;
  letter-spacing: 1px;
  margin-bottom: 0.75rem;
}

.profile__row {
  display: flex;
  align-items: center;
  gap: 0.6rem;
  font-size: 0.85rem;
  color: var(--text);
  padding: 0.35rem 0;
  cursor: default;
}

.profile__row a:not(.profile__row) {
  color: var(--accent);
}

.profile__row a:not(.profile__row):hover {
  color: var(--accent-hover);
}

.profile__icon {
  width: 16px;
  height: 16px;
  flex-shrink: 0;
  color: var(--text-dim);
}

.profile__main {
  padding-top: 0.25rem;
}

.profile__bio {
  color: var(--text-bio);
  font-size: 1rem;
  line-height: 1.8;
}

.empty {
  color: var(--text-dim);
  font-style: italic;
}

@media (max-width: 700px) {
  .profile {
    grid-template-columns: 1fr;
    gap: 1.5rem;
  }

  .profile__side {
    max-width: 320px;
    margin: 0 auto;
  }
}
</style>
