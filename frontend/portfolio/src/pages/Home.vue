<script setup lang="ts">
import data from '@/data/home.json'
</script>

<template>
  <div class="page">
    <div class="container">
      <section class="hero">
        <h1 class="hero__title">{{ data.message }}</h1>
        <p class="hero__tagline">{{ data.tagline }}</p>
        <p class="hero__desc">
          I'm a passionate developer who loves building things that live on the internet.
          I specialize in crafting clean, efficient code and turning complex problems into
          elegant solutions. When I'm not coding, you'll find me exploring new technologies,
          contributing to open source, or diving into a good tech book.
        </p>
        <a href="/cv.pdf" download class="btn btn--primary">Download CV</a>
      </section>
    </div>
  </div>
</template>

<style scoped>
.page {
  max-width: 960px;
  margin: 0 auto;
}

.hero {
  text-align: center;
  padding: 5rem 0 3rem;
}

.hero__title {
  color: var(--accent-light);
  font-size: 2.5rem;
  font-weight: 800;
  letter-spacing: 2px;
  margin-bottom: 0.75rem;
}

.hero__tagline {
  color: var(--text-muted);
  font-size: 1.15rem;
  margin-bottom: 1.5rem;
}

.hero__desc {
  color: var(--text-bio);
  font-size: 1rem;
  line-height: 1.8;
  max-width: 600px;
  margin: 0 auto 2rem;
}

.btn {
  display: inline-block;
  padding: 0.75rem 2rem;
  border-radius: 4px;
  font-weight: 600;
  font-size: 0.9rem;
  transition: all 0.2s;
}

.btn:hover {
  text-decoration: none;
}

.btn--primary {
  background: var(--accent);
  color: var(--btn-text);
}

.btn--primary:hover {
  background: var(--accent-hover);
}

@media (max-width: 768px) {
  .hero {
    padding: 3rem 1rem 2rem;
  }

  .hero__title {
    font-size: 2rem;
  }
}
</style>
