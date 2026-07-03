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
          <div class="profile__avatar">{{ profile.name.charAt(0) }}</div>
          <h2 class="profile__name">{{ profile.name }}</h2>
          <p class="profile__title">{{ profile.title }}</p>
          <p class="profile__bio">{{ profile.bio }}</p>

          <div class="profile__section">
            <h3 class="profile__section-title">Contact</h3>
            <div class="profile__grid">
              <div v-if="profile.email" class="profile__item">
                <span class="profile__label">Email</span>
                <a :href="`mailto:${profile.email}`">{{ profile.email }}</a>
              </div>
              <div v-if="profile.phone" class="profile__item">
                <span class="profile__label">Phone</span>
                <span>{{ profile.phone }}</span>
              </div>
              <div v-if="profile.location" class="profile__item">
                <span class="profile__label">Location</span>
                <span>{{ profile.location }}</span>
              </div>
            </div>
          </div>

          <div class="profile__section">
            <h3 class="profile__section-title">Links</h3>
            <div class="profile__links">
              <a v-if="profile.githubUrl" :href="profile.githubUrl" target="_blank" rel="noopener" class="btn btn--outline">GitHub</a>
              <a v-if="profile.linkedinUrl" :href="profile.linkedinUrl" target="_blank" rel="noopener" class="btn btn--outline">LinkedIn</a>
              <a v-if="profile.websiteUrl" :href="profile.websiteUrl" target="_blank" rel="noopener" class="btn btn--outline">Website</a>
            </div>
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
  max-width: 650px;
}

.profile__avatar {
  width: 80px;
  height: 80px;
  border-radius: 50%;
  background: linear-gradient(135deg, var(--accent), #e879f9);
  color: #fff;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 2rem;
  font-weight: 700;
  margin-bottom: 1.25rem;
}

.profile__name {
  color: var(--text-heading);
  font-size: 1.75rem;
  margin-bottom: 0.3rem;
}

.profile__title {
  color: var(--text-muted);
  font-size: 1.05rem;
  margin-bottom: 1.25rem;
}

.profile__bio {
  color: var(--text-bio);
  font-size: 1rem;
  line-height: 1.8;
  margin-bottom: 2rem;
  padding-bottom: 2rem;
  border-bottom: 1px solid var(--border);
}

.profile__section {
  margin-bottom: 2rem;
}

.profile__section-title {
  color: var(--text-muted);
  font-size: 0.85rem;
  font-weight: 600;
  text-transform: uppercase;
  letter-spacing: 1px;
  margin-bottom: 1rem;
}

.profile__grid {
  display: flex;
  flex-direction: column;
  gap: 0.75rem;
}

.profile__item {
  display: flex;
  gap: 0.75rem;
  font-size: 0.95rem;
}

.profile__label {
  font-weight: 600;
  min-width: 80px;
  color: var(--text-muted);
}

.profile__links {
  display: flex;
  gap: 0.75rem;
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
</style>
