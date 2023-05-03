package com.undefinedbhvr.seaborgium.compat.iris.mixin.iris;

import com.undefinedbhvr.seaborgium.Seaborgium;
import net.coderbot.iris.pipeline.PipelineManager;
import net.coderbot.iris.pipeline.WorldRenderingPipeline;
import net.coderbot.iris.shaderpack.DimensionId;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PipelineManager.class, remap = false)
public class MixinPipelineManager {
    @Inject(method = "preparePipeline", at = @At(value = "INVOKE", target = "Lnet/coderbot/iris/IrisLogging;info(Ljava/lang/String;[Ljava/lang/Object;)V"))
    private void sb$reload_on_pipeline_change(DimensionId dim, CallbackInfoReturnable<WorldRenderingPipeline> cir) {
        Seaborgium.LOGGER.warn("Shader cache needs invalidated. Reason: Iris Created New Pipeline");
        Seaborgium.invalidate_shaders();
    }
}
